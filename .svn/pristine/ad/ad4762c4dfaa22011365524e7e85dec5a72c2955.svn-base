package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.LuckdrawPrize;
import com.linkwin.activity.service.ILuckdrawPrizeService;
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
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Controller
@RequestMapping("/activity/activityConfigPrize")
public class LuckdrawPrizeController extends BaseController
{
    private String prefix = "activity/activityConfigPrize";

    @Autowired
    private ILuckdrawPrizeService luckdrawPrizeService;

    @RequiresPermissions("activity:configPrize:view")
    @GetMapping()
    public String prize()
    {
        return prefix + "/prize";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LuckdrawPrize luckdrawPrize)
    {
        startPage();
        List<LuckdrawPrize> list = luckdrawPrizeService.selectLuckdrawPrizeList(luckdrawPrize);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LuckdrawPrize luckdrawPrize)
    {
        List<LuckdrawPrize> list = luckdrawPrizeService.selectLuckdrawPrizeList(luckdrawPrize);
        ExcelUtil<LuckdrawPrize> util = new ExcelUtil<LuckdrawPrize>(LuckdrawPrize.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        return prefix + "/add";
    }


    @GetMapping("/add/{id}")
    public String editadd(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("activityid",id);
        return prefix + "/add";
    }
    /**
     * 新增保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LuckdrawPrize luckdrawPrize)
    {
        return toAjax(luckdrawPrizeService.insertLuckdrawPrize(luckdrawPrize));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LuckdrawPrize luckdrawPrize = luckdrawPrizeService.selectLuckdrawPrizeById(id);
        mmap.put("luckdrawPrize", luckdrawPrize);
        mmap.put("activityid", luckdrawPrize.getActivityid());

        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LuckdrawPrize luckdrawPrize)
    {
        return toAjax(luckdrawPrizeService.updateLuckdrawPrize(luckdrawPrize));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(luckdrawPrizeService.deleteLuckdrawPrizeByIds(ids));
    }
}
