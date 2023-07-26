package com.linkwin.report.service.impl;

import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.domain.Whstock;
import com.linkwin.basedata.mapper.WhstockMapper;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.report.domain.WarehouseStockReportForm;
import com.linkwin.report.domain.NameValue;
import com.linkwin.report.service.IWarehouseReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseReportFormServiceImpl implements IWarehouseReportFormService {


    @Autowired
    private WhstockMapper whstockMapper;

    @Override
    public AjaxResult selectWarehouseStockReportForm(Warehouse warehouse) {
        WarehouseStockReportForm result=new WarehouseStockReportForm();
        try {
            BigDecimal totalNum = whstockMapper.selectWhstockNumByWarehouse(warehouse.getWareHouseCode());
            BigDecimal inNum = whstockMapper.selectInCountByWarehouseCode(warehouse.getWareHouseCode(), 0);
            BigDecimal outNum = whstockMapper.selectInCountByWarehouseCode(warehouse.getWareHouseCode(), 1);
            Whstock whstock=new Whstock();
            whstock.setWarehouseCode(warehouse.getWareHouseCode());
            List<Whstock> whstockList = whstockMapper.selectWhstockList(whstock);
            List<String> names = whstockList.stream().map(Whstock::getProductname).collect(Collectors.toList());
            List<BigDecimal> values = whstockList.stream().map(Whstock::getInventoryquantity).collect(Collectors.toList());
            result.setTotalStock(totalNum==null?new BigDecimal(0):totalNum);
            result.setInWarehouse(inNum==null?new BigDecimal(0):inNum);
            result.setOutWarehouse(outNum==null?new BigDecimal(0):outNum);
            List<NameValue> nameValueList=new ArrayList<>();
            for (int i=0;i<names.size();i++){
                NameValue nameValue=new NameValue();
                nameValue.setName(names.get(i));
                nameValue.setValue(values.get(i));
                nameValueList.add(nameValue);
            }
            result.setNameValueList(nameValueList);
            result.setPdNameList(names);
            result.setPdNumList(values);
            return AjaxResult.success(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.error();
    }



}
