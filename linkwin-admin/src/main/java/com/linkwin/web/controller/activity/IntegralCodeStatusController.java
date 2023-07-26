package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.IntegralCodeStatus;
import com.linkwin.activity.service.IIntegralCodeStatusService;
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
 * 营销码状态Controller
 * 
 * @author ruoyi
 * @date 2022-06-15
 */
@Controller
@RequestMapping("/activity/IntegralCodeStatus")
public class IntegralCodeStatusController extends BaseController
{
    private String prefix = "activity/integralCodeStatus";

    @Autowired
    private IIntegralCodeStatusService integralCodeStatusService;

    @RequiresPermissions("activity:codeStatus:view")
    @GetMapping()
    public String status()
    {
        return prefix + "/status";
    }

    /**
     * 查询营销码状态列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IntegralCodeStatus integralCodeStatus)
    {
        startPage();
        List<IntegralCodeStatus> list = integralCodeStatusService.selectIntegralCodeStatusList(integralCodeStatus);
        return getDataTable(list);
    }

    /**
     * 导出营销码状态列表
     */
    @Log(title = "营销码状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IntegralCodeStatus integralCodeStatus)
    {
        List<IntegralCodeStatus> list = integralCodeStatusService.selectIntegralCodeStatusList(integralCodeStatus);
        ExcelUtil<IntegralCodeStatus> util = new ExcelUtil<IntegralCodeStatus>(IntegralCodeStatus.class);
        return util.exportExcel(list, "营销码状态数据");
    }

    /**
     * 新增营销码状态
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存营销码状态
     */
    @Log(title = "营销码状态", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(IntegralCodeStatus integralCodeStatus)
    {
        return toAjax(integralCodeStatusService.insertIntegralCodeStatus(integralCodeStatus));
    }

    /**
     * 修改营销码状态
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        IntegralCodeStatus integralCodeStatus = integralCodeStatusService.selectIntegralCodeStatusById(id);
        mmap.put("integralCodeStatus", integralCodeStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存营销码状态
     */
    @Log(title = "营销码状态", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(IntegralCodeStatus integralCodeStatus)
    {
        return toAjax(integralCodeStatusService.updateIntegralCodeStatus(integralCodeStatus));
    }

    /**
     * 删除营销码状态
     */
    @Log(title = "营销码状态", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(integralCodeStatusService.deleteIntegralCodeStatusByIds(ids));
    }
}
