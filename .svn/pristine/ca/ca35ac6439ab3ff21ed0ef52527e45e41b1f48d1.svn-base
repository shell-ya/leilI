package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.ExchangePrize;
import com.linkwin.activity.service.IExchangePrizeService;
import com.linkwin.common.core.domain.entity.SysDept;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.order.domain.BillOrder;
import com.linkwin.system.service.ISysDeptService;
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
 * 兑奖核销管理Controller
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
@Controller
@RequestMapping("/activity/exchangePrize")
public class ExchangePrizeController extends BaseController
{
    private String prefix = "activity/exchangePrize";

    @Autowired
    private IExchangePrizeService exchangePrizeService;
    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("activity:exchangePrize:view")
    @GetMapping()
    public String prize()
    {
        return prefix + "/prize";
    }

    /**
     * 查询兑奖核销管理列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ExchangePrize exchangePrize)
    {
        SysUser currentUser = getSysUser();
        SysDept sysDept = sysDeptService.selectDeptById(currentUser.getDeptId());
        if (currentUser.isAdminByRole() || "0".equals(sysDept.getOrganLevel())){
            startPage();
            List<ExchangePrize> list = exchangePrizeService.selectExchangePrizeList(exchangePrize);
            return getDataTable(list);
        }
        List<Long> deptIds = sysDeptService.selectDeptId(currentUser.getDeptId());
        deptIds.add(currentUser.getDeptId());
        startPage();
        List<ExchangePrize> list = exchangePrizeService.selectExchangePrizeListByDeptIds(exchangePrize,deptIds);
        return getDataTable(list);
    }

    /**
     * 导出兑奖核销管理列表
     */
    @Log(title = "兑奖核销管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExchangePrize exchangePrize)
    {
        SysUser currentUser = getSysUser();
        SysDept sysDept = sysDeptService.selectDeptById(currentUser.getDeptId());
        if (currentUser.isAdminByRole() || "0".equals(sysDept.getOrganLevel())){
            List<ExchangePrize> list = exchangePrizeService.selectExchangePrizeList(exchangePrize);
            ExcelUtil<ExchangePrize> util = new ExcelUtil<ExchangePrize>(ExchangePrize.class);
            return util.exportExcel(list, "兑奖核销管理数据");
        }

        List<Long> deptIds = sysDeptService.selectDeptId(currentUser.getDeptId());
        deptIds.add(currentUser.getDeptId());
        List<ExchangePrize> list = exchangePrizeService.selectExchangePrizeListByDeptIds(exchangePrize,deptIds);
        ExcelUtil<ExchangePrize> util = new ExcelUtil<ExchangePrize>(ExchangePrize.class);
        return util.exportExcel(list, "兑奖核销管理数据");
    }

    /**
     * 新增兑奖核销管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存兑奖核销管理
     */
    @Log(title = "兑奖核销管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ExchangePrize exchangePrize)
    {
        return toAjax(exchangePrizeService.insertExchangePrize(exchangePrize));
    }

    /**
     * 修改兑奖核销管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ExchangePrize exchangePrize = exchangePrizeService.selectExchangePrizeById(id);
        mmap.put("exchangePrize", exchangePrize);
        return prefix + "/edit";
    }

    /**
     * 修改保存兑奖核销管理
     */
    @Log(title = "兑奖核销管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ExchangePrize exchangePrize)
    {
        return toAjax(exchangePrizeService.updateExchangePrize(exchangePrize));
    }

    /**
     * 删除兑奖核销管理
     */
    @Log(title = "兑奖核销管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(exchangePrizeService.deleteExchangePrizeByIds(ids));
    }
}
