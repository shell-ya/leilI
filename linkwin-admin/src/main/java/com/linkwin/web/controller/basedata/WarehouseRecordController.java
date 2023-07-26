package com.linkwin.web.controller.basedata;

import java.util.List;
import java.util.stream.Collectors;

import com.linkwin.activity.domain.ExchangePrize;
import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.service.IWarehouseService;
import com.linkwin.common.core.domain.entity.SysDept;
import com.linkwin.common.core.domain.entity.SysUser;
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
import com.linkwin.basedata.domain.WarehouseRecord;
import com.linkwin.basedata.service.IWarehouseRecordService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

/**
 * WarehouseRecoadController
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
@Controller
@RequestMapping("/basedata/record")
public class WarehouseRecordController extends BaseController
{
    private String prefix = "basedata/record";

    @Autowired
    private IWarehouseRecordService WarehouseRecordService;
    @Autowired
    private IWarehouseService warehouseService;
    @Autowired
    private ISysDeptService sysDeptService;


    @RequiresPermissions("basedata:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询WarehouseRecoad列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarehouseRecord WarehouseRecord)
    {

        SysUser currentUser = getSysUser();
        SysDept sysDept = sysDeptService.selectDeptById(currentUser.getDeptId());
        if (currentUser.isAdminByRole() || "0".equals(sysDept.getOrganLevel())){
            startPage();
            List<WarehouseRecord> list = WarehouseRecordService.selectWarehouseRecordList(WarehouseRecord);
            return getDataTable(list);
        }

        List<Warehouse> warehouses = warehouseService.selectByOrganCode(
                String.valueOf(currentUser.getDeptId())
        );
        List<Long> deptIds = sysDeptService.selectDeptId(currentUser.getDeptId());
        deptIds.add(currentUser.getDeptId());
        List<Long> warehouseIds = warehouses.stream().map(item -> {
            return Long.parseLong(item.getWareHouseCode());
        }).collect(Collectors.toList());
        deptIds.addAll(warehouseIds);

        startPage();
        List<WarehouseRecord> list = WarehouseRecordService.selectWarehouseRecordListByWareHouse(WarehouseRecord,deptIds);
        return getDataTable(list);
    }

    /**
     * 导出WarehouseRecoad列表
     */
    @RequiresPermissions("basedata:record:export")
    @Log(title = "WarehouseRecoad", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WarehouseRecord WarehouseRecord)
    {
        SysUser currentUser = getSysUser();
        SysDept sysDept = sysDeptService.selectDeptById(currentUser.getDeptId());
        if (currentUser.isAdminByRole() || "0".equals(sysDept.getOrganLevel())){
            List<WarehouseRecord> list = WarehouseRecordService.selectWarehouseRecordList(WarehouseRecord);
            ExcelUtil<WarehouseRecord> util = new ExcelUtil<WarehouseRecord>(WarehouseRecord.class);
            return util.exportExcel(list, "WarehouseRecoad数据");
        }
        List<Warehouse> warehouses = warehouseService.selectByOrganCode(
                String.valueOf(currentUser.getDeptId())
        );
        List<Long> deptIds = sysDeptService.selectDeptId(currentUser.getDeptId());
        deptIds.add(currentUser.getDeptId());
        List<Long> warehouseIds = warehouses.stream().map(item -> {
            return Long.parseLong(item.getWareHouseCode());
        }).collect(Collectors.toList());
        deptIds.addAll(warehouseIds);
        List<WarehouseRecord> list = WarehouseRecordService.selectWarehouseRecordListByWareHouse(WarehouseRecord,deptIds);
        ExcelUtil<WarehouseRecord> util = new ExcelUtil<WarehouseRecord>(WarehouseRecord.class);
        return util.exportExcel(list, "WarehouseRecoad数据");
    }

    /**
     * 新增WarehouseRecoad
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存WarehouseRecoad
     */
    @RequiresPermissions("basedata:record:add")
    @Log(title = "WarehouseRecoad", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WarehouseRecord WarehouseRecord)
    {
        return toAjax(WarehouseRecordService.insertWarehouseRecord(WarehouseRecord));
    }

    /**
     * 修改WarehouseRecoad
     */
    @RequiresPermissions("basedata:record:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WarehouseRecord WarehouseRecord = WarehouseRecordService.selectWarehouseRecordById(id);
        mmap.put("WarehouseRecord", WarehouseRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存WarehouseRecoad
     */
    @RequiresPermissions("basedata:record:edit")
    @Log(title = "WarehouseRecoad", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WarehouseRecord WarehouseRecord)
    {
        return toAjax(WarehouseRecordService.updateWarehouseRecord(WarehouseRecord));
    }

    /**
     * 删除WarehouseRecoad
     */
    @RequiresPermissions("basedata:record:remove")
    @Log(title = "WarehouseRecoad", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(WarehouseRecordService.deleteWarehouseRecordByIds(ids));
    }
}
