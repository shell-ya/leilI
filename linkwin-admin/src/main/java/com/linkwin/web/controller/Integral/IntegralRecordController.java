package com.linkwin.web.controller.Integral;

import java.util.List;
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
import com.linkwin.Integral.domain.IntegralRecord;
import com.linkwin.Integral.service.IIntegralRecordService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * IntegralRecordController
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
@Controller
@RequestMapping("/Integral/record")
public class IntegralRecordController extends BaseController
{
    private String prefix = "Integral/record";

    @Autowired
    private IIntegralRecordService integralRecordService;

    @RequiresPermissions("IntegralRecord:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询IntegralRecord列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IntegralRecord integralRecord)
    {
        startPage();
        List<IntegralRecord> list = integralRecordService.selectIntegralRecordList(integralRecord);
        return getDataTable(list);
    }



    /**
     * 导出IntegralRecord列表
     */
    @RequiresPermissions("IntegralRecord:record:export")
    @Log(title = "IntegralRecord", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IntegralRecord integralRecord)
    {
        List<IntegralRecord> list = integralRecordService.selectIntegralRecordList(integralRecord);
        ExcelUtil<IntegralRecord> util = new ExcelUtil<IntegralRecord>(IntegralRecord.class);
        return util.exportExcel(list, "IntegralRecord数据");
    }

    /**
     * 新增IntegralRecord
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存IntegralRecord
     */
    @RequiresPermissions("IntegralRecord:record:add")
    @Log(title = "IntegralRecord", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(IntegralRecord integralRecord)
    {
        return toAjax(integralRecordService.insertIntegralRecord(integralRecord));
    }

    /**
     * 修改IntegralRecord
     */
    @RequiresPermissions("IntegralRecord:record:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        IntegralRecord integralRecord = integralRecordService.selectIntegralRecordById(id);
        mmap.put("integralRecord", integralRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存IntegralRecord
     */
    @RequiresPermissions("IntegralRecord:record:edit")
    @Log(title = "IntegralRecord", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(IntegralRecord integralRecord)
    {
        return toAjax(integralRecordService.updateIntegralRecord(integralRecord));
    }

    /**
     * 删除IntegralRecord
     */
    @RequiresPermissions("IntegralRecord:record:remove")
    @Log(title = "IntegralRecord", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(integralRecordService.deleteIntegralRecordByIds(ids));
    }
}
