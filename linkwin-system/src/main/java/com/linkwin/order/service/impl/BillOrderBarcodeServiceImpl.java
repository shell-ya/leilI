package com.linkwin.order.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.linkwin.apply.domain.BarCode;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.basedata.service.IWhstockService;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.order.domain.BillOrder;
import com.linkwin.order.mapper.BillOrderMapper;
import com.linkwin.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.order.mapper.BillOrderBarcodeMapper;
import com.linkwin.order.domain.BillOrderBarcode;
import com.linkwin.order.service.IBillOrderBarcodeService;
import com.linkwin.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 单据条码明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
@Service
public class BillOrderBarcodeServiceImpl implements IBillOrderBarcodeService 
{
    @Autowired
    private BillOrderBarcodeMapper billOrderBarcodeMapper;

    @Autowired
    private IWhstockService whstockService;

    @Autowired
    private BillOrderMapper billOrderMapper;

    @Autowired
    private IProductService productService;




    /**
     * 查询单据条码明细
     * 
     * @param id 单据条码明细主键
     * @return 单据条码明细
     */
    @Override
    public BillOrderBarcode selectBillOrderBarcodeById(Long id)
    {
        return billOrderBarcodeMapper.selectBillOrderBarcodeById(id);
    }

    /**
     * 查询单据条码明细列表
     * 
     * @param billOrderBarcode 单据条码明细
     * @return 单据条码明细
     */
    @Override
    public List<BillOrderBarcode> selectBillOrderBarcodeList(BillOrderBarcode billOrderBarcode)
    {
        return billOrderBarcodeMapper.selectBillOrderBarcodeList(billOrderBarcode);
    }

    /**
     * 新增单据条码明细
     * 
     * @param billOrderBarcode 单据条码明细
     * @return 结果
     */
    @Override
    public int insertBillOrderBarcode(BillOrderBarcode billOrderBarcode)
    {
        billOrderBarcode.setCreateTime(DateUtils.getNowDate());
        return billOrderBarcodeMapper.insertBillOrderBarcode(billOrderBarcode);
    }

    /**
     * 修改单据条码明细
     * 
     * @param billOrderBarcode 单据条码明细
     * @return 结果
     */
    @Override
    public int updateBillOrderBarcode(BillOrderBarcode billOrderBarcode)
    {
        return billOrderBarcodeMapper.updateBillOrderBarcode(billOrderBarcode);
    }

    /**
     * 批量删除单据条码明细
     * 
     * @param ids 需要删除的单据条码明细主键
     * @return 结果
     */
    @Override
    public int deleteBillOrderBarcodeByIds(String ids)
    {
        return billOrderBarcodeMapper.deleteBillOrderBarcodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除单据条码明细信息
     * 
     * @param id 单据条码明细主键
     * @return 结果
     */
    @Override
    public int deleteBillOrderBarcodeById(Long id)
    {
        return billOrderBarcodeMapper.deleteBillOrderBarcodeById(id);
    }

    @Override
    public void solutionBarcode() {

        try {
            String orders=
                    "RK202302020031\n" +
                    ",RK202302020001\n" +
                    ",RK202302010015\n" +
                    ",RK202302010013\n" +
                    ",RK202302010010\n" +
                    ",RK202302010009\n" +
                    ",RK202302010008\n" +
                    ",RK202302010007\n" +
                    ",RK202302010001\n" +
                    ",RK202301300002\n" +
                    ",RK202301290035\n" +
                    ",RK202301280002\n" +
                    ",RK202301280001\n" +
                    ",RK202301180002\n" +
                    ",RK202301180001\n" +
                    ",RK202301160003\n" +
                    ",RK202301160002\n" +
                    ",RK202301160001\n" +
                    ",RK202301140003\n" +
                    ",RK202301140002\n" +
                    ",RK202301140001\n" +
                    ",RK202301130003\n" +
                    ",RK202301130002\n" +
                    ",RK202301130001\n" +
                    ",RK202301120003\n" +
                    ",RK202301120002\n" +
                    ",RK202301120001\n" +
                    ",RK202301110003\n" +
                    ",RK202301110001\n" +
                    ",RK202301100002\n" +
                    ",RK202301100001\n" +
                    ",RK202301090004\n" +
                    ",RK202301090003\n" +
                    ",RK202301090002\n" +
                    ",RK202301090001\n" +
                    ",RK202301080006\n" +
                    ",RK202301080004\n" +
                    ",RK202301080003\n" +
                    ",RK202301080001\n" +
                    ",RK202301070003\n" +
                    ",RK202301070001\n" +
                    ",RK202301060003\n" +
                    ",RK202301040001\n" +
                    ",RK202301030001\n" +
                    ",RK202212300004\n" +
                    ",RK202212300003\n" +
                    ",RK202212290004\n" +
                    ",RK202212290003\n" +
                    ",RK202212290002\n" +
                    ",RK202212290001\n" +
                    ",RK202212280004\n" +
                    ",RK202212280003\n" +
                    ",RK202212280002\n" +
                    ",RK202212280001\n" +
                    ",RK202212270001\n" +
                    ",RK202212260001\n" +
                    ",RK202211150019\n" +
                    ",RK202211150018\n" +
                    ",RK202211150012\n" +
                    ",RK202211140016\n" +
                    ",RK202211140002\n" +
                    ",RK202211140001\n" +
                    ",RK202211130002\n" +
                    ",RK202211130001\n" +
                    ",RK202211120001\n" +
                    ",RK202211110002\n" +
                    ",RK202211110001\n" +
                    ",RK202211100005\n" +
                    ",RK202211090009\n" +
                    ",RK202211090008\n" +
                    ",RK202211080014\n" +
                    ",RK202211040003\n" +
                    ",RK202211040001\n" +
                    ",RK202211010002\n" +
                    ",RK202211010001\n" +
                    ",RK202210300003\n" +
                    ",RK202210300002\n" +
                    ",RK202210300001\n" +
                    ",RK202210290001\n" +
                    ",RK202210280003\n" +
                    ",RK202210280002\n" +
                    ",RK202210280001\n" +
                    ",RK202210270003\n" +
                    ",RK202210270001\n" +
                    ",RK202210260001\n" +
                    ",RK202210250002\n" +
                    ",RK202210250001\n" +
                    ",RK202210240003\n" +
                    ",RK202210240002\n" +
                    ",RK202210240001\n" +
                    ",RK202210230003\n" +
                    ",RK202210230002\n" +
                    ",RK202210230001\n" +
                    ",RK202210220001\n" +
                    ",RK202210210003\n" +
                    ",RK202210210002\n" +
                    ",RK202210210001\n" +
                    ",RK202210200028\n" +
                    ",RK202210200001\n" +
                    ",RK202210190003\n" +
                    ",RK202210190002\n" +
                    ",RK202210190001\n" +
                    ",RK202210180004\n" +
                    ",RK202210180003\n" +
                    ",RK202210180002\n" +
                    ",RK202210180001\n" +
                    ",RK202210170005\n" +
                    ",RK202210170004\n" +
                    ",RK202210170003\n" +
                    ",RK202210170002\n" +
                    ",RK202210170001\n" +
                    ",RK202210160001\n" +
                    ",RK202210140001\n" +
                    ",RK202210130003\n" +
                    ",RK202210130002\n" +
                    ",RK202210130001\n" +
                    ",RK202210120043\n" +
                    ",RK202210120040\n" +
                    ",RK202210120001\n" +
                    ",RK202210110002\n" +
                    ",RK202210110001\n" +
                    ",RK202210100002\n" +
                    ",RK202210100001\n" +
                    ",RK202210090002\n" +
                    ",RK202210090001\n" +
                    ",RK202210080002\n" +
                    ",RK202210080001\n" +
                    ",RK202209300009\n" +
                    ",RK202209300008\n" +
                    ",RK202209290026\n" +
                    ",RK202209290025\n" +
                    ",RK202209280017\n" +
                    ",RK202209280002\n" +
                    ",RK202209280001\n" +
                    ",RK202209270012\n" +
                    ",RK202209270008\n";

            String[] orderArray = orders.split(",");
            System.out.println("单据数量："+orderArray.length);
            for (String orderNo:orderArray){
                String order=orderNo.trim();
//                order=order.replace("\n","");
//                System.out.println(order);
                BillOrder billOrder = billOrderMapper.selectBillOrderByOrderNo(order);
                BillOrderBarcode barcode=new BillOrderBarcode();
                barcode.setOrderNo(order);
                List<BillOrderBarcode> billOrderBarcodeList = billOrderBarcodeMapper.selectBillOrderBarcodeList(barcode);
                int count=0;
                String pdCode = null;
                String pdName = null;
                for (BillOrderBarcode billOrderBarcode:billOrderBarcodeList){
                    if (pdCode==null){
                        pdCode=billOrderBarcode.getPdCode();
                    }
                    if (pdName == null){
                        pdName=billOrderBarcode.getPdName();
                    }

                    String barCode = billOrderBarcode.getBarCode();
                    BarCode code = CodeUtils.getStartAndEndNumByCode(barCode);
                    int quantity = code.getEndNum()-code.getStartNum()+1;
                    BigDecimal quantity1 = billOrderBarcode.getCaseQuantity();
                    int caseQuantity = quantity1.intValue();
                    if ((quantity-caseQuantity)!=1){
                        System.out.println(billOrderBarcode.getBarCode()+"     该码不属于需要修改的范围，请仔细检查");
                    }else {
                        count=count+1;
                    }
                }


                if (count==billOrderBarcodeList.size()){
                    System.out.println(order+"      需要补充码数量："+count+"      核对正确"+"    "+billOrder.getReceiveWarehouseName()+"   "+pdName);
                }else {
                    System.out.println(order+"      需要补充码数量："+count+"      核对异常");
                }
//                whstockService.moreWhRecord(pdCode, "2022", BigDecimal.valueOf(count), null, billOrder.getRceiveWarehouseCode(), "补充库存数据  单据号："+order+"  本次补充小件数量："+count);

            }

        }catch (Exception e){

        }











    }

    public static void main(String[] args) {
//        solutionBarcode();
    }


}
