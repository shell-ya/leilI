package com.linkwin.web.controller.Integral;

import java.util.List;

import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.mapper.ProductMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.Integral.domain.IntegralPerson;
import com.linkwin.Integral.service.IIntegralPersonService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * IntegralPersonController
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
@Controller
@RequestMapping("/Integral/person")
public class IntegralPersonController extends BaseController
{
    private String prefix = "Integral/person";

    @Autowired
    private IIntegralPersonService integralPersonService;
    @Autowired
    private ProductMapper productMapper;

//    @RequiresPermissions("IntegralPerson:person:view")
//    @GetMapping()
//    public String person()
//    {
//        return prefix + "/person";
//    }


    @GetMapping("/person/{phoneNumber}")
    public String person(@PathVariable("phoneNumber")String phoneNumber,ModelMap mmap)
    {
//        phoneNumber= "17865163215";
        List<Product> product =  productMapper.selectCashingProductList(new Product());
        mmap.put("product", product);
        mmap.put("phoneNumber",phoneNumber);
        IntegralPerson Integral = integralPersonService.selectIntegralPersonByphoneNumber(phoneNumber);
        Integer a=null;
        if(Integral==null){
            a=0;
        }else{
           a= Integral.getIntegral();
        }

        mmap.put("Integral",a);
        return prefix + "/customView";
    }

    /**
     * 查询IntegralPerson列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product queryproduct)
    {
        startPage();

        List<Product> product =  productMapper.selectCashingProductList(queryproduct);

//        List<IntegralPerson> list = integralPersonService.selectIntegralPersonList(integralPerson);
        return getDataTable(product);
    }

    /**
     * 导出IntegralPerson列表
     */
    @RequiresPermissions("IntegralPerson:person:export")
    @Log(title = "IntegralPerson", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IntegralPerson integralPerson)
    {
        List<IntegralPerson> list = integralPersonService.selectIntegralPersonList(integralPerson);
        ExcelUtil<IntegralPerson> util = new ExcelUtil<IntegralPerson>(IntegralPerson.class);
        return util.exportExcel(list, "IntegralPerson数据");
    }

    /**
     * 新增IntegralPerson
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存IntegralPerson
     */
    @RequiresPermissions("IntegralPerson:person:add")
    @Log(title = "IntegralPerson", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(IntegralPerson integralPerson)
    {
        return toAjax(integralPersonService.insertIntegralPerson(integralPerson));
    }

    /**
     * 修改IntegralPerson
     */
    @RequiresPermissions("IntegralPerson:person:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        IntegralPerson integralPerson = integralPersonService.selectIntegralPersonById(id);
        mmap.put("integralPerson", integralPerson);
        return prefix + "/edit";
    }

    /**
     * 修改保存IntegralPerson
     */
    @RequiresPermissions("IntegralPerson:person:edit")
    @Log(title = "IntegralPerson", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(IntegralPerson integralPerson)
    {
        return toAjax(integralPersonService.updateIntegralPerson(integralPerson));
    }

    /**
     * 删除IntegralPerson
     */
    @RequiresPermissions("IntegralPerson:person:remove")
    @Log(title = "IntegralPerson", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(integralPersonService.deleteIntegralPersonByIds(ids));
    }

    /**
     * 修改IntegralPerson
     */
    @GetMapping("/buy")
    public String buy(String productCode,String phoneNumber,ModelMap mmap)
    {
        Product product =  productMapper.selectProductDataByCode(productCode);
        mmap.put("product", product);
        mmap.put("phoneNumber", phoneNumber);
        return  "Integral/order/add";
    }
}
