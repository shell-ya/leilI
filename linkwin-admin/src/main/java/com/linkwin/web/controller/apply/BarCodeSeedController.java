package com.linkwin.web.controller.apply;

import java.util.List;

import com.linkwin.apply.domain.BarCodeSeed;
import com.linkwin.apply.service.IBarCodeSeedService;
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
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
@Controller
@RequestMapping("/apply/barSeed")
public class BarCodeSeedController extends BaseController
{
    private String prefix = "system/seed";

    @Autowired
    private IBarCodeSeedService barCodeSeedService;

    @RequiresPermissions("apply:seed:view")
    @GetMapping()
    public String seed()
    {
        return prefix + "/seed";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BarCodeSeed barCodeSeed)
    {
        startPage();
        List<BarCodeSeed> list = barCodeSeedService.selectBarCodeSeedList(barCodeSeed);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BarCodeSeed barCodeSeed)
    {
        List<BarCodeSeed> list = barCodeSeedService.selectBarCodeSeedList(barCodeSeed);
        ExcelUtil<BarCodeSeed> util = new ExcelUtil<BarCodeSeed>(BarCodeSeed.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BarCodeSeed barCodeSeed)
    {
        return toAjax(barCodeSeedService.insertBarCodeSeed(barCodeSeed));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BarCodeSeed barCodeSeed = barCodeSeedService.selectBarCodeSeedById(id);
        mmap.put("barCodeSeed", barCodeSeed);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BarCodeSeed barCodeSeed)
    {
        return toAjax(barCodeSeedService.updateBarCodeSeed(barCodeSeed));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(barCodeSeedService.deleteBarCodeSeedByIds(ids));
    }
}
