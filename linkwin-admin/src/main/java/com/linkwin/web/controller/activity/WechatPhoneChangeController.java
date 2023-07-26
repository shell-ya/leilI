package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.WechatPhoneChange;
import com.linkwin.activity.service.IWechatPhoneChangeService;
import com.linkwin.common.utils.poi.ExcelUtil;
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
import com.linkwin.common.core.page.TableDataInfo;

/**
 * 【绑定手机号变更记录】Controller
 * 
 * @author ruoyi
 * @date 2022-07-05
 */
@Controller
@RequestMapping("/system/change")
public class WechatPhoneChangeController extends BaseController
{
    private String prefix = "system/change";

    @Autowired
    private IWechatPhoneChangeService wechatPhoneChangeService;

    @RequiresPermissions("activity:change:view")
    @GetMapping()
    public String change()
    {
        return prefix + "/change";
    }

    /**
     * 查询【请填写功能名称】列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WechatPhoneChange wechatPhoneChange)
    {
        startPage();
        List<WechatPhoneChange> list = wechatPhoneChangeService.selectWechatPhoneChangeList(wechatPhoneChange);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WechatPhoneChange wechatPhoneChange)
    {
        List<WechatPhoneChange> list = wechatPhoneChangeService.selectWechatPhoneChangeList(wechatPhoneChange);
        ExcelUtil<WechatPhoneChange> util = new ExcelUtil<WechatPhoneChange>(WechatPhoneChange.class);
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
    public AjaxResult addSave(WechatPhoneChange wechatPhoneChange)
    {
        return toAjax(wechatPhoneChangeService.insertWechatPhoneChange(wechatPhoneChange));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WechatPhoneChange wechatPhoneChange = wechatPhoneChangeService.selectWechatPhoneChangeById(id);
        mmap.put("wechatPhoneChange", wechatPhoneChange);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WechatPhoneChange wechatPhoneChange)
    {
        return toAjax(wechatPhoneChangeService.updateWechatPhoneChange(wechatPhoneChange));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wechatPhoneChangeService.deleteWechatPhoneChangeByIds(ids));
    }
}
