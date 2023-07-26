package com.linkwin.web.controller.apply;

import java.util.List;

import com.linkwin.apply.domain.BoxCodeSeed;
import com.linkwin.apply.service.IBoxCodeSeedService;
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
@RequestMapping("/apply/boxSeed")
public class BoxCodeSeedController extends BaseController
{
    private String prefix = "system/seed";

    @Autowired
    private IBoxCodeSeedService boxCodeSeedService;

    @RequiresPermissions("system:seed:view")
    @GetMapping()
    public String seed()
    {
        return prefix + "/seed";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:seed:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BoxCodeSeed boxCodeSeed)
    {
        startPage();
        List<BoxCodeSeed> list = boxCodeSeedService.selectBoxCodeSeedList(boxCodeSeed);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:seed:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BoxCodeSeed boxCodeSeed)
    {
        List<BoxCodeSeed> list = boxCodeSeedService.selectBoxCodeSeedList(boxCodeSeed);
        ExcelUtil<BoxCodeSeed> util = new ExcelUtil<BoxCodeSeed>(BoxCodeSeed.class);
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
    @RequiresPermissions("system:seed:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BoxCodeSeed boxCodeSeed)
    {
        return toAjax(boxCodeSeedService.insertBoxCodeSeed(boxCodeSeed));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:seed:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BoxCodeSeed boxCodeSeed = boxCodeSeedService.selectBoxCodeSeedById(id);
        mmap.put("boxCodeSeed", boxCodeSeed);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:seed:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BoxCodeSeed boxCodeSeed)
    {
        return toAjax(boxCodeSeedService.updateBoxCodeSeed(boxCodeSeed));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:seed:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(boxCodeSeedService.deleteBoxCodeSeedByIds(ids));
    }
}
