package com.linkwin.web.controller.order;

import java.util.List;
import java.util.Map;

import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.domain.ProductOrgan;
import com.linkwin.basedata.domain.SysProductOrgan;
import com.linkwin.basedata.mapper.ProductOrganMapper;
import com.linkwin.basedata.mapper.SysProductOrganMapper;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.common.core.domain.entity.SysDept;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.order.domain.BillOrderBarcode;
import com.linkwin.order.domain.BillOrderDetail;
import com.linkwin.order.service.IBillOrderBarcodeService;
import com.linkwin.system.mapper.SysDeptMapper;
import com.linkwin.system.service.ISysDeptService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.order.domain.BillOrder;
import com.linkwin.order.service.IBillOrderService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * 单据Controller
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Controller
@RequestMapping("/order/order")
public class BillOrderController extends BaseController
{
    private String prefix = "order/order";

    @Autowired
    private IBillOrderService billOrderService;
    @Autowired
    private IProductService productService;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private IBillOrderBarcodeService billOrderBarcodeService;
    @Autowired
    private ProductOrganMapper sysProductOrganMapper;

    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("order:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询单据列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BillOrder billOrder)
    {

        SysUser currentUser = getSysUser();
        SysDept sysDept = sysDeptService.selectDeptById(currentUser.getDeptId());
        if (currentUser.isAdminByRole() || "0".equals(sysDept.getOrganLevel())){
            startPage();
            //出库
            billOrder.setOrderType(1);
            List<BillOrder> list = billOrderService.selectBillOrderList(billOrder);
            return getDataTable(list);
        }
        List<Long> deptIds = sysDeptService.selectDeptId(currentUser.getDeptId());
        deptIds.add(currentUser.getDeptId());
        startPage();
        //出库
        billOrder.setOrderType(1);
//        List<BillOrder> list = billOrderService.selectBillOrderList(billOrder);
        List<BillOrder> list = billOrderService.selectBillOrderListByDeptIds(billOrder,deptIds);
        return getDataTable(list);
    }

    /**
     * 导出单据列表
     */
    @RequiresPermissions("order:order:export")
    @Log(title = "单据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BillOrder billOrder)
    {
        SysUser currentUser = getSysUser();
        SysDept sysDept = sysDeptService.selectDeptById(currentUser.getDeptId());
        if (currentUser.isAdminByRole() || "0".equals(sysDept.getOrganLevel())){
            List<BillOrder> list = billOrderService.selectBillOrderList(billOrder);
            ExcelUtil<BillOrder> util = new ExcelUtil<BillOrder>(BillOrder.class);
            return util.exportExcel(list, "单据数据");
        }
        List<Long> deptIds = sysDeptService.selectDeptId(currentUser.getDeptId());
        deptIds.add(currentUser.getDeptId());
        List<BillOrder> list = billOrderService.selectBillOrderListByDeptIds(billOrder,deptIds);
        ExcelUtil<BillOrder> util = new ExcelUtil<BillOrder>(BillOrder.class);
        return util.exportExcel(list, "单据数据");
    }

    /**
     * 新增单据
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        Product product =new Product();
        mmap.put("pdCode",productService.selectProductList(product));
        SysDept sysOrgan =new SysDept();
        List<SysDept> organList = sysDeptMapper.selectDeptList(sysOrgan);
        mmap.put("organList",organList);
        return prefix + "/add";
    }

    /**
     * 新增保存单据
     */
    @RequiresPermissions("order:order:add")
    @Log(title = "单据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BillOrder billOrder)
    {
        billOrder.setReceiveOrganCode(billOrder.getCustomer());
        billOrder.setBillCreator(getSysUser().getUserName());
        if (billOrder.getBillOrderDetailList()==null||billOrder.getBillOrderDetailList().size()==0) {
//            throw new RuntimeException("单据明细不能为空！");
            throw new RuntimeException(MessageUtils.message("error.msg.documentDetails"));
        }
        String receiveOrganCode =billOrder.getReceiveOrganCode();

        for (BillOrderDetail billOrderDetail : billOrder.getBillOrderDetailList())
        {

            ProductOrgan sysProductOrgan =new ProductOrgan();
            sysProductOrgan.setOrganCode(receiveOrganCode);
            sysProductOrgan.setPdCode(billOrderDetail.getPdCode());
            List<ProductOrgan> sysProductOrganList =sysProductOrganMapper.selectProductOrganList(sysProductOrgan);
            if(sysProductOrganList.isEmpty()){
//                return AjaxResult.error("单据中产品"+"不在"+billOrder.getReceiveOrganName()+"客户的代理产品范围内！");
                return AjaxResult.error(String.format(MessageUtils.message("error.msg.agentproduct"),billOrder.getReceiveOrganName()));
            }
        }
        return toAjax(billOrderService.insertBillOrder(billOrder));
    }

    /**
     * 修改单据
     */
    @RequiresPermissions("order:order:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysDept sysOrgan=new SysDept();

        List<SysDept> organList = sysDeptMapper.selectDeptList(sysOrgan);
        mmap.put("organList",organList);
        BillOrder billOrder = billOrderService.selectBillOrderById(id);
        Product product =new Product();
        mmap.put("pdCode",productService.selectProductList(product));
        mmap.put("billOrder", billOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存单据
     */
    @RequiresPermissions("order:order:edit")
    @Log(title = "单据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BillOrder billOrder)
    {
        billOrder.setReceiveOrganCode(billOrder.getCustomer());
        if (billOrder.getBillOrderDetailList()==null||billOrder.getBillOrderDetailList().size()==0) {
//            throw new RuntimeException("单据明细不能为空！");
            throw new RuntimeException(MessageUtils.message("error.msg.documentDetails"));
        }
        String receiveOrganCode =billOrder.getReceiveOrganCode();

        for (BillOrderDetail billOrderDetail : billOrder.getBillOrderDetailList())
        {

            ProductOrgan sysProductOrgan =new ProductOrgan();
            sysProductOrgan.setOrganCode(receiveOrganCode);
            sysProductOrgan.setPdCode(billOrderDetail.getPdCode());
            List<ProductOrgan> sysProductOrganList =sysProductOrganMapper.selectProductOrganList(sysProductOrgan);
            if(sysProductOrganList.isEmpty()){
//                return AjaxResult.error("单据中产品"+"不在"+billOrder.getReceiveOrganName()+"客户的代理产品范围内！");
                return AjaxResult.error(String.format(MessageUtils.message("error.msg.agentproduct"),billOrder.getReceiveOrganName()));
            }
        }
        return toAjax(billOrderService.updateBillOrder(billOrder));
    }

    /**
     * 删除单据
     */
    @RequiresPermissions("order:order:remove")
    @Log(title = "单据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(billOrderService.deleteBillOrderByIds(ids));
    }

    /**
     * 删除条码
     */
    @Log(title = "手动复核", businessType = BusinessType.UPDATE)
    @PostMapping( "/orderClose/{orderId}")
    @ResponseBody
    public AjaxResult review(@PathVariable("orderId") Long orderId)
    {
        return billOrderService.confirmOrder(orderId);
    }


    /**
     * 删除条码
     */
    @Log(title = "删除条码", businessType = BusinessType.DELETE)
    @PostMapping( "/removeCode")
    @ResponseBody
    public AjaxResult removeCode(String ids)
    {
        return toAjax(billOrderBarcodeService.deleteBillOrderBarcodeByIds(ids));
    }


    @GetMapping("/searchWh/{organCode}")
    @ResponseBody

    public Map<String, Object> searchWh(@PathVariable("organCode") String organCode, ModelMap mmap) {


        return billOrderService.search(organCode);
    }

    @Log(title = "单据", businessType = BusinessType.UPDATE)
    @GetMapping("/personpick/{id}")

    public String personpick(@PathVariable("id") Long id, ModelMap mmap) {


        BillOrder outBill = billOrderService.selectBillOrderById(id);

        mmap.put("outBill", outBill);
        SysDept sysOrgan=new SysDept();

        List<SysDept> organList = sysDeptMapper.selectDeptList(sysOrgan);
        mmap.put("organList",organList);
        BillOrder billOrder = billOrderService.selectBillOrderById(id);
        Product product =new Product();
        mmap.put("pdCode",productService.selectProductList(product));
        mmap.put("billOrder", billOrder);
        BillOrder whstock =new BillOrder();
        whstock.setOrderType(0);
        whstock.setIsPicked(0);
        mmap.put("whBatch" ,billOrderService.selectBillOrderList(whstock));
        return prefix + "/pick";
    }


    /**
     * 修改单据
     */
    @GetMapping("/selectBatch/{id}")
    public String selectBatch(@PathVariable("id") Long id, ModelMap mmap)
    {

        try {
            BillOrderDetail billOrderDetail = billOrderService.selectBillOrderDetailById(id);

            BillOrder billOrder =billOrderService.selectBillOrderByOrderNo(billOrderDetail.getOrderNo());
//            BillOrder whstock =new BillOrder();

            mmap.put("detailId",billOrderDetail.getId());
            mmap.put("rceiveWarehouseCode",billOrder.getSendWarehouseCode());
            mmap.put("customer", billOrder.getCustomer());
            mmap.put("pdCode",billOrderDetail.getPdCode());
        }catch (Exception e){
            return prefix + "/whstock";
        }

        return prefix + "/whstock";
    }

    /**
     * 查询库存管理列表
     */
    @PostMapping("/whstocklist")
    @ResponseBody
    public TableDataInfo whstocklist(BillOrder billOrder)
    {

        startPage();
        List<BillOrder> billOrderList =billOrderService.selectImBillOrderByPdCodeAndRceiveWarehouseCode(billOrder.getCustomer(),billOrder.getRceiveWarehouseCode(),billOrder.getPdCode());
        return getDataTable(billOrderList);
    }

    /**
     * 人工拣货
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/savebatchs")
    @ResponseBody
    @Transactional
    public AjaxResult savebatchs(@Param("detailId") Long detailId,@Param("Oids") String Oids    ) {


        return billOrderService.savebatchs(detailId,Oids);
    }

    /**
     * 查看详细
     */
    @GetMapping("/Billdetail/{id}")
    public String Billdetail(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysDept sysOrgan=new SysDept();

        List<SysDept> organList = sysDeptMapper.selectDeptList(sysOrgan);
        mmap.put("organList",organList);
        BillOrder billOrder = billOrderService.selectBillOrderById(id);
        Product product =new Product();
        mmap.put("pdCode",productService.selectProductList(product));
        mmap.put("billOrder", billOrder);
        return prefix + "/detail";
    }

    @GetMapping("/selectbarcode/{id}")
    public String selectbarcode(@PathVariable("id") Long id, ModelMap mmap)
    {
//        BillOrderDetail detail = billOrderDetailService.selectBillOrderDetailById(id);
//        BillOrder billOrder = billOrderMapper.selectByOrderNo(detail.getOrderNo());
//        if (billOrder.getIsChecked()==1){
//            mmap.put("isChecked",1);
//        }
        mmap.put("detailId",id);
        return prefix+"/code";
    }

    /**
     * 查询单据条码明细列表
     */
    @PostMapping("/codelist")
    @ResponseBody
    public TableDataInfo codelist(BillOrderBarcode billOrderBarcode)
    {
        startPage();
        List<BillOrderBarcode> list = billOrderBarcodeService.selectBillOrderBarcodeList(billOrderBarcode);
        return getDataTable(list);
    }
}
