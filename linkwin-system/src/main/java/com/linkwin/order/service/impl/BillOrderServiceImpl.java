package com.linkwin.order.service.impl;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.linkwin.apply.domain.BarCode;
import com.linkwin.apply.domain.BoxCode;
import com.linkwin.apply.mapper.BarCodeMapper;
import com.linkwin.apply.mapper.BoxCodeMapper;
import com.linkwin.apply.mapper.SubCodeMapper;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.domain.ProductOrgan;
import com.linkwin.basedata.domain.SysProductOrgan;
import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.mapper.DeptMapper;
import com.linkwin.basedata.mapper.ProductMapper;
import com.linkwin.basedata.mapper.ProductOrganMapper;
import com.linkwin.basedata.mapper.SysProductOrganMapper;
import com.linkwin.basedata.service.IWhstockService;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.common.utils.ShiroUtils;
import com.linkwin.log.domain.UploadLog;
import com.linkwin.log.mapper.UploadLogMapper;
import com.linkwin.order.domain.BillOrderBarcode;
import com.linkwin.order.mapper.BillOrderBarcodeMapper;
import com.linkwin.system.mapper.SysDeptMapper;
import com.linkwin.utils.*;
import com.linkwin.vo.FwFlowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkwin.common.utils.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.linkwin.order.domain.BillOrderDetail;
import com.linkwin.order.mapper.BillOrderMapper;
import com.linkwin.order.domain.BillOrder;
import com.linkwin.order.service.IBillOrderService;
import com.linkwin.common.core.text.Convert;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 单据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class BillOrderServiceImpl implements IBillOrderService
{
   @Autowired
   private BillOrderMapper billOrderMapper;
   @Autowired
   private BillOrderBarcodeMapper billOrderBarcodeMapper;
   @Autowired
   private UploadLogMapper uploadLogMapper;
   @Autowired
   private IWhstockService whstockService;
   @Autowired
   private ProductMapper productMapper;
    @Autowired
    private SubCodeMapper subCodeMapper;
    @Autowired
    private BarCodeMapper barCodeMapper;
    @Autowired
    private ProductOrganMapper sysProductOrganMapper;

    @Autowired
    private BoxCodeMapper boxCodeMapper;
    @Autowired
    private GetOrderNoUtils getOrderNoUtils;

    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private DeptMapper deptMapper;


    /**
     * 查询单据
     * 
     * @param id 单据主键
     * @return 单据
     */
    @Override
    public BillOrder selectBillOrderById(Long id)
    {
        return billOrderMapper.selectBillOrderById(id);
    }

    /**
     * 查询单据列表
     * 
     * @param billOrder 单据
     * @return 单据
     */
    @Override
    public List<BillOrder> selectBillOrderList(BillOrder billOrder)
    {
        return billOrderMapper.selectBillOrderList(billOrder);
    }

    /**
     * 新增单据
     * 
     * @param billOrder 单据
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBillOrder(BillOrder billOrder)
    {
        if(billOrder.getBillOrderDetailList()==null)
        billOrder.setCreateTime(DateUtils.getNowDate());
        billOrder.setOrderNo(getOrderNoUtils.serinalNo(1));
        billOrder.setIsChecked(0);
        billOrder.setOrderType(1);
        int rows = billOrderMapper.insertBillOrder(billOrder);
        insertBillOrderDetail(billOrder);
        return rows;
    }

    /**
     * 修改单据
     * 
     * @param billOrder 单据
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBillOrder(BillOrder billOrder)
    {
        billOrderMapper.deleteBillOrderDetailByOrderNo(billOrder.getOrderNo());
        insertBillOrderDetail(billOrder);
        return billOrderMapper.updateBillOrder(billOrder);
    }

    public static boolean checkTime(String text)
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date date = (Date)formatter.parse(text);
            return text.equals(formatter.format(date));
        }
        catch (Exception e)
        {

        }
        return false;
    }
    /**
     * 批量删除单据
     * 
     * @param ids 需要删除的单据主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBillOrderByIds(String ids)
    {
       Long[] orderids = Convert.toLongArray(ids);
       for(Long orderid :orderids){
           billOrderMapper.deleteBillOrderDetailByOrderNo(billOrderMapper.selectBillOrderById(orderid).getOrderNo());
       }
        return billOrderMapper.deleteBillOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除单据信息
     * 
     * @param id 单据主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBillOrderById(Long id)
    {

        billOrderMapper.deleteBillOrderDetailByOrderNo(billOrderMapper.selectBillOrderById(id).getOrderNo());
        return billOrderMapper.deleteBillOrderById(id);
    }

    @Override
    public AjaxResult confirmOrder(Long orderId) {
        if (Objects.isNull(orderId)){
            return AjaxResult.error();
        }

        BillOrder billOrder = billOrderMapper.selectBillOrderById(orderId);

        if (Objects.isNull(billOrder)){
            return AjaxResult.error();
        }
        if (isConfirm(billOrder.getOrderNo())) {
            BillOrderBarcode billOrderBarcode=new BillOrderBarcode();
            billOrderBarcode.setOrderNo(billOrder.getOrderNo());
            billOrderBarcode.setIsChecked(Integer.parseInt(ConstEnum.BARCODE_CHECKED.getValue()));
            billOrderBarcodeMapper.updateBillOrderBarcodeByorderNo(billOrderBarcode);
            billOrderMapper.updateBillOrderclose(billOrder.getOrderNo());//关单
            List<BillOrderDetail> billOrderDetails = billOrderMapper.selectByOrderNo(billOrder.getOrderNo());
            for(BillOrderDetail closeBOD: billOrderDetails) {
                whstockService.whRecord(closeBOD.getPdCode(), "2022", closeBOD.getQuantity(), billOrder.getSendWarehouseCode(), billOrder.getCustomer(), billOrder.getBillCreator() + ":销售出库", "2022", 1);
            }
            return AjaxResult.success(MessageUtils.message("success"));
        } else {
//                        msg.append("条码已上传，因条码数量与单据明细数量不符，暂时不能关单");
//            msg.append(MessageUtils.message("error.msg.cannotclose"));
                        return AjaxResult.error(MessageUtils.message("error.msg.cannotclose"));
        }
    }

    /**
     * 新增单据明细信息
     * 
     * @param billOrder 单据对象
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void insertBillOrderDetail(BillOrder billOrder)
    {
        List<BillOrderDetail> billOrderDetailList = billOrder.getBillOrderDetailList();
        String orderNo = billOrder.getOrderNo();
        if (StringUtils.isNotNull(billOrderDetailList))
        {
            List<BillOrderDetail> list = new ArrayList<BillOrderDetail>();
            for (BillOrderDetail billOrderDetail : billOrderDetailList)
            {
                billOrderDetail.setOrderNo(orderNo);
                list.add(billOrderDetail);
            }
            if (list.size() > 0)
            {
                billOrderMapper.batchBillOrderDetail(list);
            }
        }
    }
    @Transactional(rollbackFor = RuntimeException.class,propagation = Propagation.REQUIRED)
    @Override
    public AjaxResult dealOutBillUpload(List<Map<String, Object>> Lmap)throws RuntimeException {
        StringBuffer msg =new StringBuffer();
        for (Map<String, Object> map:Lmap) {
            UploadLog uploadLog = new UploadLog();
            uploadLog.setCreateTime(DateUtils.getNowDate());
            SysUser user = ShiroUtils.getSysUser();
            try {
                BillOrderDetail emptybillOrder = new BillOrderDetail();
                String log = JSONObject.toJSONString(map);

//                      List maps=JSONObject.parseArray(log);
                uploadLog.setJson(log);
                String orderNo = null;
                Long detailId = null;
                String WarehouseCode;
//          List<BillOrderBarcode> barcodeList =new ArrayList<BillOrderBarcode>();
//          List<barcodeVO> dataList = JSON.parseArray(JSONObject.toJSONString(map.get("dataList")), barcodeVO.class);
                String codes = map.get("QRCode").toString();
                String customer =  map.get("customer").toString();
                String[] codeArray = Convert.toStrArray(codes);
                orderNo = map.get("OrderNo").toString();
//                WarehouseCode = map.get("WarehouseCode").toString();
                msg.append(orderNo);
//            String receiveOrganCode = map.get("receiveOrganCode").toString();
//                String sendOrganCode = map.get("sendOrganCode").toString();
                String sendOrganCode= user.getDeptId().toString();
                Warehouse Warehouse = deptMapper.selectByOrganCode(sendOrganCode);
                WarehouseCode=Warehouse.getWareHouseCode();
                String productCode = map.get("productCode").toString();
                if (!StringUtils.isEmpty(map.get("detailId").toString())) {
                    detailId = Long.parseLong(map.get("detailId").toString());
                }


                Product product = new Product();
                boolean noBillFlag = false;
                if (codeArray == null && codeArray.length == 0) {
//                    throw new RuntimeException("条码不能为空");
                    throw new RuntimeException(MessageUtils.message("error.msg.cannotempty"));

                }else if(StringUtils.isEmpty(customer)){
//                    throw new RuntimeException("客户不能为空");
                    throw new RuntimeException(MessageUtils.message("error.msg.custmoerempty"));
                }
            List<BillOrderBarcode> newbarlist = new ArrayList<BillOrderBarcode>();
                int itemnumbers = 0;


                if (orderNo.isEmpty() || (detailId == null || "".equals(detailId))) {
                    noBillFlag = true;
                    //创建新的order
                    orderNo = getOrderNoUtils.serinalNo(1);
//                if(StringUtils.isEmpty(receiveOrganCode)) {
//                    throw new RuntimeException("该单据为无单上传，但是缺少收货仓库");
//                }else
                    if (StringUtils.isEmpty(sendOrganCode)) {
//                        throw new RuntimeException("该单据为无单上传，但是缺少发货机构");
                        throw new RuntimeException(MessageUtils.message("error.msg.noshippingagency"));
                    } else if (StringUtils.isEmpty(productCode)) {
//                        throw new RuntimeException("该单据为无单上传，但是缺少产品编码");
                        throw new RuntimeException(MessageUtils.message("error.msg.misscode"));
                    } else if (StringUtils.isEmpty(WarehouseCode)) {
//                        throw new RuntimeException("该单据为无单上传，但是缺少发货仓库");
                        throw new RuntimeException(MessageUtils.message("error.msg.misswarehouse"));
                    }
                    product = productMapper.selectProductDataByCode(productCode);

                    ProductOrgan queryprod = new ProductOrgan();
                    queryprod.setPdCode(productCode);
                    queryprod.setOrganCode(sendOrganCode);
                     List<ProductOrgan> a =sysProductOrganMapper.selectProductOrganList(queryprod);
                     if(a.isEmpty()){
//                         throw new RuntimeException("该机构没有产品"+product.getName()+"的代理权，所以无法出库给该机构");
                         throw new RuntimeException(String.format(MessageUtils.message("error.msg.distributedtotheorganization"),product.getName()));
                     }

                    noBillUpload(BigDecimal.valueOf(codeArray.length), orderNo, product, sendOrganCode, WarehouseCode, 1 ,customer);
                    BillOrderDetail tmpdetail = billOrderMapper.selectByOrderNoAndPdCode(orderNo, product.getCode());

                    detailId = tmpdetail.getId();

                } else {
                    BillOrder billOrder = new BillOrder();
                    billOrder.setOrderNo(orderNo);
                    billOrder.setDetailId(detailId);
                    List<BillOrder> emptyOrder = billOrderMapper.selectBillOrderByorderNoAnddetailID(billOrder);

                    if (emptyOrder.size() == 1) {
                        emptybillOrder = emptyOrder.get(0).getBillOrderDetailList().get(0);
                        product = productMapper.selectProductDataByCode(emptybillOrder.getPdCode());
                        WarehouseCode = emptyOrder.get(0).getSendWarehouseCode();
                        sendOrganCode = emptyOrder.get(0).getSendOrganCode();
// bug                       BillOrder Order = emptyOrder.get(0);
//                        Order.setCustomer(customer);
//                        billOrderMapper.updateBillOrder(Order);

                    } else if (emptyOrder.size() == 0) {
//                        throw new RuntimeException("该单据或单据明细不存在");
                        throw new RuntimeException(MessageUtils.message("error.msg.documentdetailsnotexist"));
                    } else {
//                        throw new RuntimeException("该单据或单据明细存在多条");
                        throw new RuntimeException(MessageUtils.message("error.msg.multipledocumentdetails"));
                    }
                    Integer isCheck =emptyOrder.get(0).getIsChecked();
                    if (isCheck!=null&&isCheck== 1) {

//                        throw new RuntimeException("该单据已经出库");
                        throw new RuntimeException(MessageUtils.message("error.msg.documentissued"));
                    }

                }


                List<String> codeList = Arrays.asList(codeArray);///
                if(codeList.size()>1000){
//                    throw new RuntimeException("单次扫描条码不能超过一千条");
                    throw new RuntimeException(MessageUtils.message("error.msg.maximum1000"));
                }
                uploadLog.setHandleMsg(String.valueOf(codeList.size()));
                String codeType = null;
                String codeFirst = codeList.get(0);
                try {
                    CodeUtils.verifyCode(codeFirst);
                    codeType = CodeUtils.getCodeTypeByCode(codeFirst);
                }catch (Exception e){
                    throw new RuntimeException(e.getMessage());
                }
                String lastYear = TableUtils.getYearByCode(codeFirst);
                String year = "20" + lastYear;
                if (CodeEnum.BAR_CODE.getValue().equals(codeType)) {

                    String subTableName = TableUtils.getBarTableByYear(Integer.valueOf(year));
                    int i = subCodeMapper.queryTableName(subTableName);
                    if (i == 0) {
//                        throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                        throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                    }
                }else if (CodeEnum.BOX_CODE.getValue().equals(codeType)) {
                    String subTableName = TableUtils.getBoxTableByYear(Integer.valueOf(year));
                    int i = subCodeMapper.queryTableName(subTableName);
                    if (i == 0) {
//                        throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                        throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                    }
                }

                List<String> boxList = new ArrayList<String>();
                List<String> barList = new ArrayList<String>();
                for (String code : codeArray) {
                    //校验码格式
                     try {
                        CodeUtils.verifyCode(code);
                        codeType = CodeUtils.getCodeTypeByCode(code);
                    }catch (Exception e){
                        throw new RuntimeException(e.getMessage());
                    }

                    Integer BarCodeType = null;
                    if (CodeEnum.BAR_CODE.getValue().equals(codeType)) {
                        BarCodeType = 2;
                        barList.add(code);
                    } else if (CodeEnum.BOX_CODE.getValue().equals(codeType)) {
                        BarCodeType = 3;
                        boxList.add(code);
                    }


                    BarCode barCode=new BarCode();
//                    if (codeType == "2" || "2".equals(codeType)) {
//                          barCode = CodeUtils.getStartAndEndNumByCode(code);
//                        newnumber = barCode.getEndNum().intValue() - barCode.getStartNum().intValue()+1;
//                    } else {

                        barCode = CodeUtils.getStartAndEndNumByCode(code);


//                    }
                     BillOrderBarcode detail = new BillOrderBarcode();
                    if (codeType == "2" || "2".equals(codeType)) {
                        detail.setEndLogisticsCode(barCode.getEndNum()==null?0:barCode.getEndNum());
                        detail.setStartLogisticsCode(barCode.getStartNum()==null?0:barCode.getStartNum());

                    } else {
                        detail.setEndLogisticsCode(0);
                        detail.setStartLogisticsCode(0);

                    }
                    detail.setDetailId(detailId);
                    detail.setOrderNo(orderNo);
                    detail.setBarCode(code);//校验马规范
                    detail.setPdCode(product.getCode());
                    detail.setPdName(product.getName());
                    detail.setCaseQuantity(BigDecimal.valueOf(1));
                    detail.setBarCodeType(BarCodeType);
                    detail.setIsChecked(Integer.parseInt(ConstEnum.BARCODE_CHECKED.getValue()));
                    detail.setBarCodeType(Integer.valueOf(codeType));

//                    billOrderBarcodeMapper.insertBillOrderBarcode(detail);
                    newbarlist.add(detail);
                }
                List<BillOrderBarcode>billOrderBarcodeList=billOrderBarcodeMapper.selectBillOrderBarcodeListByArray(2,codeArray);
                if(!billOrderBarcodeList.isEmpty()&&billOrderBarcodeList.size()>0){
                    StringBuffer codeBuffer =new StringBuffer();
                    for (BillOrderBarcode temp:billOrderBarcodeList){
                        codeBuffer.append(temp.getBarCode()+",");
                    }
//                    throw new RuntimeException("其中"+billOrderBarcodeList.size()+"个条码已经扫码出库，勿重复上传:"+codeBuffer.toString()  );
                    throw new RuntimeException(String.format(MessageUtils.message("error.msg.beenscanned"),billOrderBarcodeList.size())+codeBuffer.toString()  );
                }
                if(barList.size()>0) {
                    String[] barArray = barList.toArray(new String[barList.size()]);

                    String subTableName = TableUtils.getBarTableByYear(Integer.valueOf(year));
                    int i = subCodeMapper.queryTableName(subTableName);
                    if (i == 0) {
//                        throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                        throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                    }
                    List<BarCode> barCodeList = barCodeMapper.selectByCodeArray(subTableName,barArray);
                    if (barCodeList.size() < barList.size()) {
//                        throw new RuntimeException("部分条码在系统中不存在");
                        throw new RuntimeException(MessageUtils.message("error.msg.barcodenotsystem"));
                    }
                    StringBuffer nulltips = new StringBuffer();
                    StringBuffer othertips = new StringBuffer();

                    for(BarCode subCode:barCodeList){
                        if(subCode.getPdCode()==null||"".equals(subCode.getPdCode())){
                            nulltips.append(subCode.getBarCode()+",");
                        }else  if (!product.getCode().equals(subCode.getPdCode()) ){
                            othertips.append(subCode.getBarCode()+",");
                        }
                    }
                    if(nulltips.toString()!=null&&!"".equals(nulltips.toString())){
//                        throw new RuntimeException( "部分条码在系统中未上传："+nulltips);
                        throw new RuntimeException( MessageUtils.message("error.msg.barcodeuploadsystem")+nulltips);
                    }
                    if(othertips.toString()!=null&&!"".equals(othertips.toString())){
//                        throw new RuntimeException( " 部分条码与产品不符："+othertips);
                        throw new RuntimeException( MessageUtils.message("error.msg.barcodeuploadsystem")+nulltips);
                    }
                }
                if (boxList.size()>0){

                    String[] boxArray = boxList.toArray(new String[boxList.size()]);
                    String boxTableName = TableUtils.getBoxTableByYear(Integer.valueOf(year));

                    int i = subCodeMapper.queryTableName(boxTableName);
                    if (i == 0) {
//                        throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                        throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                    }
                    List<BoxCode> boxCodeList= boxCodeMapper.selectByCodeArray(boxTableName, boxArray);
                    if (boxCodeList.size() < boxList.size()) {
//                        throw new RuntimeException("部分条码在系统中不存在");
                        throw new RuntimeException(MessageUtils.message("error.msg.barcodenotsystem"));
                    }
                    StringBuffer nulltips = new StringBuffer();
                    StringBuffer othertips = new StringBuffer();
                    for(BoxCode subCode:boxCodeList){
                        if(subCode.getPdCode()==null||"".equals(subCode.getPdCode())){
                            nulltips.append(subCode.getBoxCode()+",");
                        }else  if (!product.getCode().equals(subCode.getPdCode()) ){
                            othertips.append(subCode.getBoxCode()+",");
                        }
                    }
                    if(nulltips.toString()!=null&&!"".equals(nulltips.toString())){
//                        throw new RuntimeException( "部分条码在系统中未上传："+nulltips);
                        throw new RuntimeException( MessageUtils.message("error.msg.barcodeuploadsystem")+nulltips);
                    }
                    if(othertips.toString()!=null&&!"".equals(othertips.toString())){
//                        throw new RuntimeException( " 部分条码与产品不符："+othertips);
                        throw new RuntimeException( MessageUtils.message("error.msg.codematchproduct")+othertips);

                    }
//                        barCodeMapper.updateBarCode(boxTableName, product.getCode(), "box_code", code);
                    ;
                }
                //批量插入
                billOrderBarcodeMapper.insertbarcodeList(newbarlist);

                uploadLog.setBillNo(orderNo);

                List a = billOrderBarcodeMapper.selectByOrderNoAndPdCode(orderNo,product.getCode(),detailId);
                itemnumbers =a.size();
                if (noBillFlag) {
                    emptybillOrder.setQuantity(BigDecimal.valueOf(itemnumbers));
                    billOrderMapper.updateBillOrderDetail(emptybillOrder);
                    //无单
//                String sendorgan = user.getDept().getDeptId().toString();
                    billOrderMapper.updateBillOrderclose(orderNo);//关单
                    List<BillOrderDetail> billOrderDetails = billOrderMapper.selectByOrderNo(orderNo);
                    for(BillOrderDetail closeBOD: billOrderDetails) {
                            whstockService.whRecord(closeBOD.getPdCode(), "2022", closeBOD.getQuantity(), WarehouseCode, customer, user.getUserName() + ":无单出库", "2022", 1);
                    }
                 } else {
                    if (isConfirm(orderNo)) {
                        BillOrderBarcode billOrderBarcode=new BillOrderBarcode();
                        billOrderBarcode.setOrderNo(orderNo);
                        billOrderBarcode.setIsChecked(Integer.parseInt(ConstEnum.BARCODE_CHECKED.getValue()));
                        billOrderBarcodeMapper.updateBillOrderBarcodeByorderNo(billOrderBarcode);
                        billOrderMapper.updateBillOrderclose(orderNo);//关单
                        List<BillOrderDetail> billOrderDetails = billOrderMapper.selectByOrderNo(orderNo);
                        for(BillOrderDetail closeBOD: billOrderDetails) {
                            whstockService.whRecord(closeBOD.getPdCode(), "2022", closeBOD.getQuantity(), WarehouseCode, customer, user.getUserName() + ":销售出库", "2022", 1);
                        }
                    } else {
//                        msg.append("条码已上传，因条码数量与单据明细数量不符，暂时不能关单");
                        msg.append(MessageUtils.message("error.msg.cannotclose"));
//                        return AjaxResult.success("条码已上传，因条码数量与单据明细数量不符，暂时不能关单");
                    }

                }
                uploadLog.setIsDeal(1);
                uploadLog.setResponse("上传成功");
            } catch (RuntimeException e) {
                e.printStackTrace();
                uploadLog.setIsDeal(2);
                uploadLog.setResponse("上传失败" + e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return AjaxResult.error("上传失败"+e.getMessage());


            } finally {
                uploadLogMapper.insertUploadLog(uploadLog);

            }
        }
//         return AjaxResult.success("上传成功"+msg.toString());
        return AjaxResult.success(MessageUtils.message("error.msg.Uploadsuccess")+msg.toString());
    }

    /**
     * 前端搜索
     * @param code
     * @return
     */
    public  Map<String, Object>  search(String code){
        Map<String, Object> mapResult = new HashMap<>();
        try {

            List<Warehouse> WarehouseList = billOrderMapper.selectByOrganCode(code);
            if (WarehouseList!=null&&!WarehouseList.isEmpty()) {
                mapResult.put("isSuccess", true);
                mapResult.put("warehouseList", JSONObject.toJSON(WarehouseList));
            }else{
                mapResult.put("isSuccess", true);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            mapResult.put("isSuccess", false);
            mapResult.put("errorMsg", "系统异常");
        }
        return mapResult;
    }

    /**
     * 判断是否关单
     * @param orderNo
     * @return
     */
    public boolean isConfirm(String orderNo) {
        //复核
        List<BillOrderDetail> billOrderDetails = billOrderMapper.selectByOrderNo(orderNo);
        boolean isCheck = false;
        if (billOrderDetails != null) {
            boolean checkProduct = true;
            for (int i = 0; i < billOrderDetails.size(); i++) {
                BigDecimal caseQuantity = billOrderDetails.get(i).getQuantity();//箱数量
                List<BillOrderBarcode>  orderBarcodes= billOrderBarcodeMapper.selectByOrderNoAndPdCode(orderNo, billOrderDetails.get(i).getPdCode(), billOrderDetails.get(i).getId());
                BigDecimal quantity = BigDecimal.valueOf(0);
                int count = 0;
                for (BillOrderBarcode billOrderBarcode : orderBarcodes) {
//                    count += CodeUtils.getQuantity(billOrderBarcode.getBarCode());
                    count += billOrderBarcode.getCaseQuantity().intValue();
                }
                if (caseQuantity.intValue() != count) {
                    checkProduct = false;
                    break;
                } else if (caseQuantity.intValue() != count) {
                    checkProduct = false;
                    break;
                }
                if (billOrderDetails.size() - 1 == i && checkProduct) {
                    isCheck = true;
                }
            }
        }
        return isCheck;
    }


    /**
     * 无单上传生成明细
     *
     */
    public void noBillUpload(  BigDecimal caseQunantity,String orderNo, Product product,String OrganCode ,String WarehouseCode,Integer OrderType,String customer) throws RuntimeException {
        BigDecimal weight=null;
        //按照码类型
//        if (codeType == 2) {//托码
//            caseQunantity=BigDecimal.valueOf(CodeUtils.getQuantity(billOrderBarcode.getBarCode()));
//        } else {
//            caseQunantity = BigDecimal.valueOf(1);
//        }
        BillOrder querybill=new BillOrder();
        querybill.setOrderNo(orderNo);
        List<BillOrder> bill= billOrderMapper.selectBillOrderList(querybill);
        if(bill.isEmpty()) {
            BillOrder newBillOrder = new BillOrder();
            //更新
            newBillOrder.setBillCreator(ShiroUtils.getSysUser().getUserName());
            if(!StringUtils.isEmpty(customer)&&!"null".equals(customer)){
                newBillOrder.setCustomer(customer);
                newBillOrder.setCustomerName(sysDeptMapper.selectDeptById(Long.parseLong(customer)).getDeptName());
                }
            newBillOrder.setOrderNo(orderNo);
            newBillOrder.setOrderType(OrderType);//制剂入库单
            if (OrderType==0) {
                newBillOrder.setReceiveOrganCode(OrganCode);//收货机构编码
                newBillOrder.setReceiveOrganName(sysDeptMapper.selectDeptById(Long.parseLong(OrganCode)).getDeptName());//收货机构名称
                newBillOrder.setReceiveWarehouseName(deptMapper.selectByCode(WarehouseCode).getName());//收货仓库名称
                newBillOrder.setRceiveWarehouseCode(WarehouseCode);
            } else {
                newBillOrder.setSendOrganCode(OrganCode);
                newBillOrder.setSendWarehouseCode(WarehouseCode);
                newBillOrder.setSendOrganName(sysDeptMapper.selectDeptById(Long.parseLong(OrganCode)).getDeptName());
                newBillOrder.setSendWarehouseName(deptMapper.selectByCode(WarehouseCode).getName());
            }
            newBillOrder.setIsPicked(0);//未拣货
            newBillOrder.setIsChecked(0);//为复核
            newBillOrder.setCreateTime(new Date());
            billOrderMapper.insertBillOrder(newBillOrder);
        }else{
            BillOrder newBillOrder =bill.get(0);
            if(!StringUtils.isEmpty(customer)&&!"null".equals(customer)){
                newBillOrder.setCustomer(customer);
                newBillOrder.setCustomerName(sysDeptMapper.selectDeptById(Long.parseLong(customer)).getDeptName());
            }
            newBillOrder.setOrderType(OrderType);//制剂入库单
            if (OrderType==0) {
                newBillOrder.setReceiveOrganCode(OrganCode);//收货机构编码
                newBillOrder.setReceiveOrganName(sysDeptMapper.selectDeptById(Long.parseLong(OrganCode)).getDeptName());//收货机构名称
                newBillOrder.setReceiveWarehouseName(deptMapper.selectByCode(WarehouseCode).getName());//收货仓库名称
                newBillOrder.setRceiveWarehouseCode(WarehouseCode);
            } else {
                newBillOrder.setSendOrganCode(OrganCode);
                newBillOrder.setSendWarehouseCode(WarehouseCode);
                newBillOrder.setSendOrganName(sysDeptMapper.selectDeptById(Long.parseLong(OrganCode)).getDeptName());
                newBillOrder.setSendWarehouseName(deptMapper.selectByCode(WarehouseCode).getName());
            }
            newBillOrder.setIsPicked(0);//未拣货
            newBillOrder.setIsChecked(0);//为复核
            newBillOrder.setCreateTime(new Date());
            billOrderMapper.updateBillOrder(newBillOrder);
        }


        weight=product.getCartonWeight().multiply(caseQunantity);

        BillOrderDetail  billOrderDetail=billOrderMapper.selectByOrderNoAndPdCode(orderNo, product.getCode());


        if (billOrderDetail == null) {//如果不存在产品明细，明细则新增一条产品明细
            billOrderDetail = new BillOrderDetail();
            billOrderDetail.setPdName(product.getName());//产品名称
            billOrderDetail.setPdCode(product.getCode());//产品编号
            billOrderDetail.setOrderNo(orderNo);//单据号

            billOrderDetail.setQuantity(caseQunantity);//箱数
            billOrderDetail.setUnit(product.getDosageForm());//单位
            billOrderDetail.setWeight(weight);//总重量
            List<BillOrderDetail> list = new ArrayList<BillOrderDetail>();
            list.add(billOrderDetail);//新增明细
            billOrderMapper.batchBillOrderDetail(list);
        } else {
            billOrderDetail.setQuantity(billOrderDetail.getQuantity().add(caseQunantity));//箱数
            weight = billOrderDetail.getWeight().add(weight);
            billOrderDetail.setWeight(weight);//总重量

            billOrderMapper.updateBillOrderDetail(billOrderDetail);
        }
        return  ;

    }

    /**
     *
     * @param
     * @return
     */

    @Transactional(rollbackFor = RuntimeException.class,propagation = Propagation.REQUIRED)
    @Override
    public AjaxResult dealInBillUpload(List<Map<String, Object>> Listmap) {
        for(Map<String, Object> map:Listmap) {
            UploadLog uploadLog = new UploadLog();
            uploadLog.setCreateTime(DateUtils.getNowDate());

            SysUser user = ShiroUtils.getSysUser();
            try {
                BillOrderDetail emptybillOrder = new BillOrderDetail();
                String log = JSONObject.toJSONString(map);
                uploadLog.setJson(log);
                String orderNo = null;
                Long detailId = null;
                String WarehouseCode;
//          List<BillOrderBarcode> barcodeList =new ArrayList<BillOrderBarcode>();
//          List<barcodeVO> dataList = JSON.parseArray(JSONObject.toJSONString(map.get("dataList")), barcodeVO.class);
                String codes = map.get("QRCode").toString();
                String[] codeArray = Convert.toStrArray(codes);
                orderNo = map.get("OrderNo").toString();
                String customer =  map.get("customer").toString();
                //待PDA升级后放开
                String makeDate =  map.get("makeDate").toString();
                Date date = new Date();
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String makeDate = format.format(date);
//                if(StringUtils.isEmpty(makeDate)){
//                    throw new RuntimeException("生产时间为空"+makeDate);
//                }
//                if(checkTime(makeDate)){
//
//                }else{
//                    throw new RuntimeException("生产时间格式不正确"+makeDate);
//                }

                //----------------分隔符--------------
//                WarehouseCode = map.get("WarehouseCode").toString();
//            String receiveOrganCode = map.get("receiveOrganCode").toString();
//                String receiveOrganCode = map.get("receiveOrganCode").toString();
                String receiveOrganCode= user.getDeptId().toString();
                Warehouse Warehouse = deptMapper.selectByOrganCode(receiveOrganCode);
                WarehouseCode=Warehouse.getWareHouseCode();
                String productCode = map.get("productCode").toString();
                if (!StringUtils.isEmpty(map.get("detailId").toString())) {
                    detailId = Long.parseLong(map.get("detailId").toString());
                }


                Product product = new Product();
                boolean noBillFlag = false;
                if (codeArray == null && codeArray.length == 0) {
                    //                    throw new RuntimeException("条码不能为空");
                    throw new RuntimeException(MessageUtils.message("error.msg.cannotempty"));

                }
            List<BillOrderBarcode> newbarlist = new ArrayList<BillOrderBarcode>();
                int itemnumber = 0;


                if (orderNo.isEmpty() || (detailId == null || "".equals(detailId))) {
                    noBillFlag = true;
                    //创建新的order
                    orderNo = getOrderNoUtils.serinalNo(0);
//                if(StringUtils.isEmpty(receiveOrganCode)) {
//                    throw new RuntimeException("该单据为无单上传，但是缺少收货仓库");
//                }else

                    if (StringUtils.isEmpty(receiveOrganCode)) {
//                        throw new RuntimeException("该单据为无单上传，但是缺少收货机构");
                        throw new RuntimeException(MessageUtils.message("error.msg.Thedocumentisanuploadwithoutadocument,butthereceivingorganizationismissing"));
                    } else if (StringUtils.isEmpty(productCode)) {
                        // TODO: 2023/7/13  无单上传不需要上传产品
                        // todo web出库需要有一个手动复核功能 复核完成 单据明细数量和实际扫描条码数量相等 关单扣减库存
//                        throw new RuntimeException("该单据为无单上传，但是缺少产品编码");
                        throw new RuntimeException(MessageUtils.message("error.msg.misscode"));
                    } else if (StringUtils.isEmpty(WarehouseCode)) {
//                        throw new RuntimeException("该单据为无单上传，但是缺少收货仓库");
                        throw new RuntimeException(MessageUtils.message("error.msg.Thedocumentisanuploadwithoutadocument,butthereceivingwarehouseismissing"));
                    }
                    product = productMapper.selectProductDataByCode(productCode);

                    noBillUpload(BigDecimal.valueOf(codeArray.length), orderNo, product, receiveOrganCode, WarehouseCode, 0,customer);

                    BillOrderDetail tmpdetail = billOrderMapper.selectByOrderNoAndPdCode(orderNo, product.getCode());

                    detailId = tmpdetail.getId();

                } else {
                    BillOrder billOrder = new BillOrder();
                    billOrder.setOrderNo(orderNo);
                    billOrder.setDetailId(detailId);
                    List<BillOrder> emptyOrder = billOrderMapper.selectBillOrderByorderNoAnddetailID(billOrder);

                    if (emptyOrder.size() == 1) {
                        BillOrder Order = emptyOrder.get(0);

                        emptybillOrder = Order.getBillOrderDetailList().get(0);
                        product = productMapper.selectProductDataByCode(emptybillOrder.getPdCode());
                        WarehouseCode = Order.getSendWarehouseCode();



                    } else if (emptyOrder.size() == 0) {
//                        throw new RuntimeException("该单据或单据明细不存在");
                        throw new RuntimeException(MessageUtils.message("error.msg.documentdetailsnotexist"));
                    } else {
//                        throw new RuntimeException("该单据或单据明细存在多条");
                        throw new RuntimeException(MessageUtils.message("error.msg.multipledocumentdetails"));
                    }

                    if (emptyOrder.get(0).getIsChecked() == 1) {
//                        throw new RuntimeException("该单据已经出库");
                        throw new RuntimeException(MessageUtils.message("error.msg.documentissued"));

                    }


                }
                List<String> codeList = Arrays.asList(codeArray);///
                if(codeList.size()>1000){
//                    throw new RuntimeException("单次扫描条码不能超过一千条");
                    throw new RuntimeException(MessageUtils.message("error.msg.maximum1000"));
                }
                uploadLog.setHandleMsg(String.valueOf(codeList.size()));
                 String codeType = null;
                String codeFirst = codeList.get(0);
                try {
                    CodeUtils.verifyCode(codeFirst);
                    codeType = CodeUtils.getCodeTypeByCode(codeFirst);
                }catch (Exception e){
                    throw new RuntimeException(e.getMessage());
                }
                String lastYear = TableUtils.getYearByCode(codeFirst);
                String year = "20" + lastYear;
                if (CodeEnum.BAR_CODE.getValue().equals(codeType)) {

                    String subTableName = TableUtils.getBarTableByYear(Integer.valueOf(year));
                    int i = subCodeMapper.queryTableName(subTableName);
                    if (i == 0) {
//                        throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                        throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                    }
                }else if (CodeEnum.BOX_CODE.getValue().equals(codeType)) {
                    String subTableName = TableUtils.getBoxTableByYear(Integer.valueOf(year));
                    int i = subCodeMapper.queryTableName(subTableName);
                    if (i == 0) {
//                        throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                        throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                    }
                }

                List<String> boxList = new ArrayList<String>();
                List<String> barList = new ArrayList<String>();
                 for (String code : codeArray) {
                    //校验码格式

                    try {
                        CodeUtils.verifyCode(code);
                         codeType = CodeUtils.getCodeTypeByCode(code);
                    }catch (Exception e){
                        throw new RuntimeException(e.getMessage());
                    }
                    Integer BarCodeType = null;

                    if (CodeEnum.BAR_CODE.getValue().equals(codeType)) {
                        BarCodeType = 2;
                        barList.add(code);
                    } else if (CodeEnum.BOX_CODE.getValue().equals(codeType)) {
                        BarCodeType = 3;
                        boxList.add(code);
                    }

                    int newnumber = 0;
                    BillOrderBarcode detail = new BillOrderBarcode();
                    BarCode barCode = CodeUtils.getStartAndEndNumByCode(code);

//                    if (codeType == "2" || "2".equals(codeType)) {
//
//                        detail.setEndLogisticsCode(barCode.getEndNum()==null?0:barCode.getEndNum());
//                        detail.setStartLogisticsCode(barCode.getStartNum()==null?0:barCode.getStartNum());
//                    } else {
//                        detail.setEndLogisticsCode(0);
//                        detail.setStartLogisticsCode(0);
//
//                    }
                     newnumber = 1;
                     if (codeType == "2" || "2".equals(codeType)) {
//                         newnumber = barCode.getEndNum().intValue() - barCode.getStartNum().intValue()+1;
                         detail.setEndLogisticsCode(barCode.getEndNum()==null?0:barCode.getEndNum());
                         detail.setStartLogisticsCode(barCode.getStartNum()==null?0:barCode.getStartNum());
                     } else {
                         detail.setEndLogisticsCode(0);
                         detail.setStartLogisticsCode(0);
//                         newnumber = 1;
                     }
                    itemnumber += newnumber;
                    detail.setDetailId(detailId);
                    detail.setOrderNo(orderNo);
                    detail.setBarCode(code);//校验马规范
                    detail.setPdCode(product.getCode());
                    detail.setPdName(product.getName());
                    detail.setCaseQuantity(BigDecimal.valueOf(newnumber));
                    detail.setBarCodeType(BarCodeType);
                    detail.setBarCodeType(Integer.valueOf(codeType));

                     newbarlist.add(detail);
                }

                List<BillOrderBarcode>billOrderBarcodeList=billOrderBarcodeMapper.selectBillOrderBarcodeListByArray(null,codeArray);
                if(!billOrderBarcodeList.isEmpty()&&billOrderBarcodeList.size()>0){
                    StringBuffer codeBuffer =new StringBuffer();
                    for (BillOrderBarcode temp:billOrderBarcodeList){
                        codeBuffer.append(temp.getBarCode()+",");
                    }
//                    throw new RuntimeException("其中"+billOrderBarcodeList.size()+"个条码已上传完毕，勿重复上传:"+codeBuffer.toString()  );
                    throw new RuntimeException(String.format(MessageUtils.message("error.msg.beenscanned"),billOrderBarcodeList.size())+codeBuffer.toString()  );
                }
                 if(barList.size()>0) {

                     String[] barArray = barList.toArray(new String[barList.size()]);

                     String subTableName = TableUtils.getBarTableByYear(Integer.valueOf(year));
                     int i = subCodeMapper.queryTableName(subTableName);
                     if (i == 0) {
//                         throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                         throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                     }
                     List<BarCode> barCodeList = barCodeMapper.selectByCodeArray(subTableName,barArray);
                     if (barCodeList.size() < barList.size()) {
//                         throw new RuntimeException("部分条码在系统中不存在");
                         throw new RuntimeException(MessageUtils.message("error.msg.barcodenotsystem"));
                     }
                     barCodeMapper.updateBarCodeBycodeArray(subTableName, product.getCode(), makeDate,"bar_code", barArray);
                     for (BarCode barCode:barCodeList) {
                         barCodeMapper.updateSubCodePdcode(TableUtils.getSubTableByYear(Integer.valueOf(year)), product.getCode(),makeDate, barCode.getStartNum(), barCode.getEndNum(),barCode.getPrefixCode());
                     }

                 }
                 if (boxList.size()>0){
                     String[] boxArray = boxList.toArray(new String[boxList.size()]);
                     String boxTableName = TableUtils.getBoxTableByYear(Integer.valueOf(year));

                      int i = subCodeMapper.queryTableName(boxTableName);
                     if (i == 0) {
//                         throw new RuntimeException(codeFirst + "该条码在系统中不存在");
                         throw new RuntimeException(codeFirst + MessageUtils.message("error.msg.barcodenotexistsystem"));
                     }
                     List<BoxCode> boxCodeList = boxCodeMapper.selectByCodeArray(boxTableName, boxArray);
                     if (boxCodeList.size() < boxList.size()) {
//                         throw new RuntimeException("部分条码在系统中不存在");
                         throw new RuntimeException(MessageUtils.message("error.msg.barcodenotsystem"));
                     }
                     barCodeMapper.updateBarCodeBycodeArray(boxTableName, product.getCode(), makeDate,"box_code", boxArray);

                 }
                //批量插入
                billOrderBarcodeMapper.insertbarcodeList(newbarlist);
                uploadLog.setBillNo(orderNo);


                if (noBillFlag) {
                    emptybillOrder.setQuantity(BigDecimal.valueOf(itemnumber));
                    billOrderMapper.updateBillOrderDetail(emptybillOrder);

                    //无单
//                String sendorgan = user.getDept().getDeptId().toString();
                    billOrderMapper.updateBillOrderclose(orderNo);//关单
                    whstockService.moreWhRecord(productCode, "2022", BigDecimal.valueOf(itemnumber), null, WarehouseCode, user.getUserName() + ":无单生产入库");

                } else {
                    if (isConfirm(orderNo)) {

                        billOrderMapper.updateBillOrderclose(orderNo);//关单
                        whstockService.moreWhRecord(product.getCode(), "2022", BigDecimal.valueOf(itemnumber), null, WarehouseCode, user.getUserName() + ":生产入库");

                    } else {
//                        throw new RuntimeException("条码已上传，因条码数量与单据明细数量不符，暂时不能关单");
                        throw new RuntimeException(MessageUtils.message("error.msg.cannotclos"));
                    }

                }
                uploadLog.setIsDeal(1);
                uploadLog.setResponse("上传成功");
            } catch (Exception e) {
                e.printStackTrace();
                uploadLog.setIsDeal(2);
                uploadLog.setResponse("上传失败" + e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

//                return AjaxResult.error("上传失败 " + e.getMessage());
                return AjaxResult.error(MessageUtils.message("error.msg.Uploadfailed") + e.getMessage());

            } finally {
                uploadLogMapper.insertUploadLog(uploadLog);

            }
        }
//        return AjaxResult.success("上传成功");
        return AjaxResult.success(MessageUtils.message("error.msg.Uploadsuccess"));
    }

    @Override
    public BillOrderDetail selectBillOrderDetailById(Long id){
        return billOrderMapper.selectBillOrderDetailById(id);
    }
    @Override
    public BillOrder selectBillOrderByOrderNo(String orderNo){
        return billOrderMapper.selectBillOrderByOrderNo(orderNo);
    }
    @Override
    public List<BillOrder> selectImBillOrderByPdCodeAndRceiveWarehouseCode(String customer,String rceiveWarehouseCode,String pdCode){
        return billOrderMapper.selectImBillOrderByPdCodeAndRceiveWarehouseCode(customer,rceiveWarehouseCode,pdCode);
    }

    @Transactional
    @Override
    public AjaxResult savebatchs(Long detailId,String Oids){
        String[] orderids = Convert.toStrArray(Oids);
        int number = 0;
        for (String orderNo:orderids){
            BillOrderBarcode billOrderBarcode=new BillOrderBarcode();
            billOrderBarcode.setOrderNo(orderNo);
            billOrderBarcode.setReviewerId(detailId);
             number += billOrderBarcodeMapper.updateBillOrderBarcodeByorderNo(billOrderBarcode);
             billOrderMapper.updateBillOrderPicked(orderNo);
        }
        BillOrderDetail billOrderDetail= new BillOrderDetail();
        billOrderDetail.setId(detailId);
        billOrderDetail.setQuantity(BigDecimal.valueOf(number));
        billOrderMapper.updateBillOrderDetail(billOrderDetail);
        return AjaxResult.success();
    }

    @Override
    public List<FwFlowVo> selectOrderFlow(String barCode) {
        if (StringUtils.isEmpty(barCode)){
            return null;
        }
        return billOrderMapper.selectOrderFlow(barCode);
    }

    @Override
    public List<BillOrder> selectBillOrderListByDeptIds(BillOrder billOrder, List<Long> deptIds) {
        if (billOrder.getOrderType() == 1 ){
            return billOrderMapper.selectBillOrderListByDeptIds(billOrder,deptIds);
        }else {
            return billOrderMapper.selectRKBillOrderListByDeptIds(billOrder,deptIds);
        }

    }

    /**
     * 作废条码
     * @param Listmap
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class,propagation = Propagation.REQUIRED)
    @Override
    public AjaxResult cancelUploadCodeFile(List<Map<String, Object>> Listmap) {
        StringBuffer msg = new StringBuffer();
        for (Map<String, Object> map : Listmap) {
            UploadLog uploadLog = new UploadLog();
            uploadLog.setCreateTime(DateUtils.getNowDate());
            SysUser user = ShiroUtils.getSysUser();
            try {
                String log = JSONObject.toJSONString(map);
                uploadLog.setJson(log);

                String codes = map.get("QRCode").toString();
                String[] codeArray = Convert.toStrArray(codes);
//                String WarehouseCode = map.get("WarehouseCode").toString();
//                String sendOrganCode = map.get("sendOrganCode").toString();

                String sendOrganCode= user.getDeptId().toString();
                Warehouse Warehouse = deptMapper.selectByOrganCode(sendOrganCode);
                String WarehouseCode=Warehouse.getWareHouseCode();
                if (codeArray == null && codeArray.length == 0) {
//                    throw new RuntimeException("条码不能为空");
                    throw new RuntimeException(MessageUtils.message("error.msg.cannotempty"));
                }else if (StringUtils.isEmpty(sendOrganCode)) {
//                    throw new RuntimeException("该单据缺少当前机构");
                    throw new RuntimeException(MessageUtils.message("error.msg.Thedocumentismissingthecurrentorganization"));
                } else if (StringUtils.isEmpty(WarehouseCode)) {
//                    throw new RuntimeException("该单据缺少当前机构");
                    throw new RuntimeException(MessageUtils.message("error.msg.Thedocumentismissingthecurrentorganization"));
                }

                for (String code : codeArray) {
                    //校验码格式
                    String codeType = null;
                    try {
                        CodeUtils.verifyCode(code);
                        codeType = CodeUtils.getCodeTypeByCode(code);
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    String lastYear = TableUtils.getYearByCode(code);
                    String year = "20" + lastYear;
                    BillOrderBarcode queryBean = new BillOrderBarcode();
                    queryBean.setIsChecked(Integer.parseInt(ConstEnum.BARCODE_CHECKED.getValue()));
                    queryBean.setBarCode(code);
                    List<BillOrderBarcode> billOrderBarcodeList = billOrderBarcodeMapper.selectBillOrderBarcodeList(queryBean);
                    if (!billOrderBarcodeList.isEmpty() && billOrderBarcodeList.size() > 0) {
//                        throw new RuntimeException(code + "该条码在系统中已经出库");
                        throw new RuntimeException(code + MessageUtils.message("error.msg.Thebarcodehasalreadybeencheckedoutinthesystem"));
                    }
                    //删除入库条码
                    String pdCode = null;
                    billOrderBarcodeMapper.deleteBillOrderBarcodeByCode(code);
                    if (CodeEnum.BAR_CODE.getValue().equals(codeType)) {
                        String subTableName = TableUtils.getBarTableByYear(Integer.valueOf(year));
                        int i = subCodeMapper.queryTableName(subTableName);
                        if (i == 0) {
//                            throw new RuntimeException(code + "该条码在系统中不存在");
                            throw new RuntimeException(MessageUtils.message("error.msg.barcodenotexistsystem"));
                        }
                        BarCode subCode = barCodeMapper.selectByCode(subTableName, code);
                        if (subCode == null) {
//                            throw new RuntimeException(code + "该条码在系统中不存在");
                            throw new RuntimeException(MessageUtils.message("error.msg.barcodenotexistsystem"));

                        }
                        pdCode = subCode.getPdCode();
//                        barCodeMapper.updateBarCode(subTableName, "", "bar_code", code);
//                        barCodeMapper.updateSubCodePdcode(TableUtils.getSubTableByYear(Integer.valueOf(year)), "", subCode.getStartNum(), subCode.getEndNum(),subCode.getPrefixCode());

                    } else if (CodeEnum.BOX_CODE.getValue().equals(codeType)) {
                        String boxTableName = TableUtils.getBoxTableByYear(Integer.valueOf(year));
                        int i = subCodeMapper.queryTableName(boxTableName);
                        if (i == 0) {
//                            throw new RuntimeException(code + "该条码在系统中不存在");
                            throw new RuntimeException(MessageUtils.message("error.msg.barcodenotexistsystem"));
                        }
                        BoxCode boxCode = boxCodeMapper.selectByCode(boxTableName, code);
                        if (boxCode == null) {
//                            throw new RuntimeException(code + "该条码在系统中不存在");
                            throw new RuntimeException(MessageUtils.message("error.msg.barcodenotexistsystem"));
                        }
                        pdCode = boxCode.getPdCode();
//                        barCodeMapper.updateBarCode(boxTableName, "", "box_code", code);

                    }
                    whstockService.reduceWhRecord(pdCode, "2022", BigDecimal.valueOf(1), WarehouseCode, user.getUserName() + ":作废出库", 1);
                }
                uploadLog.setBillNo("作废出库");
                uploadLog.setIsDeal(1);
                uploadLog.setResponse("上传成功");
            } catch (RuntimeException e) {
                e.printStackTrace();
                uploadLog.setIsDeal(2);
                uploadLog.setResponse("上传失败" + e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

//                return AjaxResult.error("上传失败" + e.getMessage());
                return AjaxResult.error(MessageUtils.message("error.msg.Uploadfailed") + e.getMessage());
            } finally {
                uploadLogMapper.insertUploadLog(uploadLog);

            }
        }
        return AjaxResult.success(MessageUtils.message("error.msg.Uploadsuccess") + msg.toString());
//        return AjaxResult.success("上传成功" + msg.toString());
    }




}
