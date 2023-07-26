package com.linkwin.web.controller.basedata;

import java.util.List;

import com.linkwin.basedata.domain.ProductOrgan;
import com.linkwin.basedata.service.IProductOrganService;
import com.linkwin.common.utils.poi.ExcelUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * 机构代理产品关联Controller
 * 
 * @author ruoyi
 * @date 2022-08-15
 */
@Controller
@RequestMapping("/basedata/organProduct")
public class ProductOrganController extends BaseController
{
    private String prefix = "basedata/organProduct";

    @Autowired
    private IProductOrganService productOrganService;

    @GetMapping()
    public String organ(ModelMap mmap,String organCode)
    {
        mmap.put("organCode",organCode);
        return prefix + "/organ";
    }

    /**
     * 查询机构代理产品关联列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductOrgan productOrgan)
    {
        String organCode = productOrgan.getOrganCode();
        if (organCode.indexOf(",")>0){
            organCode=organCode.replace(",","");
        }
        productOrgan.setOrganCode(organCode);
        startPage();
        List<ProductOrgan> list = productOrganService.selectProductOrganList(productOrgan);
        return getDataTable(list);
    }

    /**
     * 查询机构代理产品关联列表
     */
    @PostMapping("/listNotIn")
    @ResponseBody
    public TableDataInfo listNotIn(ProductOrgan productOrgan)
    {
        String organCode = productOrgan.getOrganCode();
        if (organCode.indexOf(",")>0){
            organCode=organCode.replace(",","");
        }
        productOrgan.setOrganCode(organCode);
        startPage();
        List<ProductOrgan> list = productOrganService.selectNotInOrganList(productOrgan);
        return getDataTable(list);
    }


    /**
     * 新增机构代理产品关联
     */
    @GetMapping("/add/{organCode}")
    public String add(ModelMap mmap,@PathVariable("organCode") String organCode)
    {
        mmap.put("organCode",organCode);
        return prefix + "/addOrganProduct";
    }

    /**
     * 新增保存机构代理产品关联
     */
    @Log(title = "机构代理产品关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("pdList[]") List<String> pdList, @RequestParam("organCode") String organCode)
    {
        return toAjax(productOrganService.addSaves(pdList,organCode));
    }

    /**
     * 修改机构代理产品关联
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProductOrgan productOrgan = productOrganService.selectProductOrganById(id);
        mmap.put("productOrgan", productOrgan);
        return prefix + "/edit";
    }

    /**
     * 修改保存机构代理产品关联
     */
    @Log(title = "机构代理产品关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductOrgan productOrgan)
    {
        return toAjax(productOrganService.updateProductOrgan(productOrgan));
    }

    /**
     * 删除机构代理产品关联
     */
    @Log(title = "机构代理产品关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productOrganService.deleteProductOrganByIds(ids));
    }




}
