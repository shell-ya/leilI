package com.linkwin.web.controller.apply;

import java.util.List;

import com.linkwin.apply.domain.BoxCodePre;
import com.linkwin.apply.service.IBoxCodePreService;
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
 * 箱袋码预生成Controller
 * 
 * @author ruoyi
 * @date 2022-05-12
 */
@Controller
@RequestMapping("/apply/boxCodePre")
public class BoxCodePreController extends BaseController
{
    private String prefix = "system/pre";

    @Autowired
    private IBoxCodePreService boxCodePreService;

    @RequiresPermissions("system:pre:view")
    @GetMapping()
    public String pre()
    {
        return prefix + "/pre";
    }

    /**
     * 查询箱袋码预生成列表
     */
    @RequiresPermissions("system:pre:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BoxCodePre boxCodePre)
    {
        startPage();
        List<BoxCodePre> list = boxCodePreService.selectBoxCodePreList(boxCodePre);
        return getDataTable(list);
    }

    /**
     * 导出箱袋码预生成列表
     */
    @RequiresPermissions("system:pre:export")
    @Log(title = "箱袋码预生成", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BoxCodePre boxCodePre)
    {
        List<BoxCodePre> list = boxCodePreService.selectBoxCodePreList(boxCodePre);
        ExcelUtil<BoxCodePre> util = new ExcelUtil<BoxCodePre>(BoxCodePre.class);
        return util.exportExcel(list, "箱袋码预生成数据");
    }

    /**
     * 新增箱袋码预生成
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存箱袋码预生成
     */
    @RequiresPermissions("system:pre:add")
    @Log(title = "箱袋码预生成", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BoxCodePre boxCodePre)
    {
        return toAjax(boxCodePreService.insertBoxCodePre(boxCodePre));
    }

    /**
     * 修改箱袋码预生成
     */
    @RequiresPermissions("system:pre:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BoxCodePre boxCodePre = boxCodePreService.selectBoxCodePreById(id);
        mmap.put("boxCodePre", boxCodePre);
        return prefix + "/edit";
    }

    /**
     * 修改保存箱袋码预生成
     */
    @RequiresPermissions("system:pre:edit")
    @Log(title = "箱袋码预生成", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BoxCodePre boxCodePre)
    {
        return toAjax(boxCodePreService.updateBoxCodePre(boxCodePre));
    }

    /**
     * 删除箱袋码预生成
     */
    @RequiresPermissions("system:pre:remove")
    @Log(title = "箱袋码预生成", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(boxCodePreService.deleteBoxCodePreByIds(ids));
    }
}
