package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.ExchangeIntegral;
import com.linkwin.activity.service.IExchangeIntegralService;
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
 * 兑换积分记录Controller
 * 
 * @author ruoyi
 * @date 2022-06-14
 */
@Controller
@RequestMapping("/activity/exchangeIntegral")
public class ExchangeIntegralController extends BaseController
{
    private String prefix = "activity/exchangeIntegral";

    @Autowired
    private IExchangeIntegralService exchangeIntegralService;

    @RequiresPermissions("activity:exchangeIntegral:view")
    @GetMapping()
    public String integral()
    {
        return prefix + "/integral";
    }

    /**
     * 查询兑换积分记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ExchangeIntegral exchangeIntegral)
    {
        startPage();
        List<ExchangeIntegral> list = exchangeIntegralService.selectExchangeIntegralList(exchangeIntegral);
        return getDataTable(list);
    }

    /**
     * 导出兑换积分记录列表
     */
    @Log(title = "兑换积分记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExchangeIntegral exchangeIntegral)
    {
        List<ExchangeIntegral> list = exchangeIntegralService.selectExchangeIntegralList(exchangeIntegral);
        ExcelUtil<ExchangeIntegral> util = new ExcelUtil<ExchangeIntegral>(ExchangeIntegral.class);
        return util.exportExcel(list, "兑换积分记录数据");
    }

    /**
     * 新增兑换积分记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存兑换积分记录
     */
    @Log(title = "兑换积分记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ExchangeIntegral exchangeIntegral)
    {
        return toAjax(exchangeIntegralService.insertExchangeIntegral(exchangeIntegral));
    }

    /**
     * 修改兑换积分记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ExchangeIntegral exchangeIntegral = exchangeIntegralService.selectExchangeIntegralById(id);
        mmap.put("exchangeIntegral", exchangeIntegral);
        return prefix + "/edit";
    }

    /**
     * 修改保存兑换积分记录
     */
    @Log(title = "兑换积分记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ExchangeIntegral exchangeIntegral)
    {
        return toAjax(exchangeIntegralService.updateExchangeIntegral(exchangeIntegral));
    }

    /**
     * 删除兑换积分记录
     */
    @Log(title = "兑换积分记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(exchangeIntegralService.deleteExchangeIntegralByIds(ids));
    }
}
