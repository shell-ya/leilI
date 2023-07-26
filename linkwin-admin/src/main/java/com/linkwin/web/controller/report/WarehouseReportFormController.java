package com.linkwin.web.controller.report;

import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.service.IWarehouseService;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.report.domain.WarehouseStockReportForm;
import com.linkwin.report.service.IWarehouseReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/report")
public class WarehouseReportFormController {

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private IWarehouseReportFormService warehouseReportFormService;

    private static final String prefix="report";

    @GetMapping("warehouseStockReportForm")
    public String warehouseStockReportForm(ModelMap mmap){
        List<Warehouse> warehouseList = warehouseService.selectWarehouseList(new Warehouse());
        if (warehouseList.size()>0){
            mmap.put("warehouseList",warehouseList);
        }
        return prefix+"/warehouseStockReportForm";
    }

    @ResponseBody
    @PostMapping("warehouseDetailReport")
    public AjaxResult selectWarehouseStockReportForm(Warehouse warehouse){
        return warehouseReportFormService.selectWarehouseStockReportForm(warehouse);
    }





}
