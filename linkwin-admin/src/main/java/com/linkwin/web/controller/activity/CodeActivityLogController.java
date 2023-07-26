package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.CodeActivityLog;
import com.linkwin.activity.service.ICodeActivityLogService;
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
 * 条码参加活动记录Controller
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
@Controller
@RequestMapping("/activity/activityLog")
public class CodeActivityLogController extends BaseController
{
    private String prefix = "activity/activityLog";

    @Autowired
    private ICodeActivityLogService codeActivityLogService;

    @RequiresPermissions("activity:activitylog:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询条码参加活动记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CodeActivityLog codeActivityLog)
    {
        startPage();
        List<CodeActivityLog> list = codeActivityLogService.selectCodeActivityLogList(codeActivityLog);
        return getDataTable(list);
    }

    /**
     * 导出条码参加活动记录列表
     */
    @Log(title = "条码参加活动记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CodeActivityLog codeActivityLog)
    {
        List<CodeActivityLog> list = codeActivityLogService.selectCodeActivityLogList(codeActivityLog);
        ExcelUtil<CodeActivityLog> util = new ExcelUtil<CodeActivityLog>(CodeActivityLog.class);
        return util.exportExcel(list, "条码参加活动记录数据");
    }

    /**
     * 新增条码参加活动记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存条码参加活动记录
     */
    @Log(title = "条码参加活动记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CodeActivityLog codeActivityLog)
    {
        return toAjax(codeActivityLogService.insertCodeActivityLog(codeActivityLog));
    }

    /**
     * 修改条码参加活动记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CodeActivityLog codeActivityLog = codeActivityLogService.selectCodeActivityLogById(id);
        mmap.put("codeActivityLog", codeActivityLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存条码参加活动记录
     */
    @Log(title = "条码参加活动记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CodeActivityLog codeActivityLog)
    {
        return toAjax(codeActivityLogService.updateCodeActivityLog(codeActivityLog));
    }

    /**
     * 删除条码参加活动记录
     */
    @Log(title = "条码参加活动记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(codeActivityLogService.deleteCodeActivityLogByIds(ids));
    }
}
