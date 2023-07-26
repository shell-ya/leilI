package com.linkwin.web.controller.log;

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
import com.linkwin.log.domain.UploadLog;
import com.linkwin.log.service.IUploadLogService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * 上传sap文件处理Controller
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
@Controller
@RequestMapping("/system/log")
public class UploadLogController extends BaseController
{
    private String prefix = "system/log";

    @Autowired
    private IUploadLogService uploadLogService;

    @RequiresPermissions("system:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询上传sap文件处理列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UploadLog uploadLog)
    {
        startPage();
        List<UploadLog> list = uploadLogService.selectUploadLogList(uploadLog);
        return getDataTable(list);
    }

    /**
     * 导出上传sap文件处理列表
     */
    @RequiresPermissions("system:log:export")
    @Log(title = "上传sap文件处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UploadLog uploadLog)
    {
        List<UploadLog> list = uploadLogService.selectUploadLogList(uploadLog);
        ExcelUtil<UploadLog> util = new ExcelUtil<UploadLog>(UploadLog.class);
        return util.exportExcel(list, "上传sap文件处理数据");
    }

    /**
     * 新增上传sap文件处理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存上传sap文件处理
     */
    @RequiresPermissions("system:log:add")
    @Log(title = "上传sap文件处理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UploadLog uploadLog)
    {
        return toAjax(uploadLogService.insertUploadLog(uploadLog));
    }

    /**
     * 修改上传sap文件处理
     */
    @RequiresPermissions("system:log:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UploadLog uploadLog = uploadLogService.selectUploadLogById(id);
        mmap.put("uploadLog", uploadLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存上传sap文件处理
     */
    @RequiresPermissions("system:log:edit")
    @Log(title = "上传sap文件处理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UploadLog uploadLog)
    {
        return toAjax(uploadLogService.updateUploadLog(uploadLog));
    }

    /**
     * 删除上传sap文件处理
     */
    @RequiresPermissions("system:log:remove")
    @Log(title = "上传sap文件处理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uploadLogService.deleteUploadLogByIds(ids));
    }
}
