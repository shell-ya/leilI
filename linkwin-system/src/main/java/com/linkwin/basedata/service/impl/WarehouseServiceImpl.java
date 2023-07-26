package com.linkwin.basedata.service.impl;

import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.mapper.WarehouseMapper;
 import com.linkwin.basedata.service.IWarehouseService;
import com.linkwin.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * WarehouseService业务层处理
 * 
 * @author ymding
 * @date 2021-10-26
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService 
{
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询Warehouse
     * 
     * @param id Warehouse主键
     * @return Warehouse
     */
    @Override
    public Warehouse selectWarehouseById(Long id)
    {
        return warehouseMapper.selectWarehouseById(id);
    }

    /**
     * 查询Warehouse列表
     * 
     * @param Warehouse Warehouse
     * @return Warehouse
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse Warehouse)
    {
        return warehouseMapper.selectWarehouseList(Warehouse);
    }

    /**
     * 新增Warehouse
     * 
     * @param Warehouse Warehouse
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse Warehouse)
    {
        Warehouse temp =warehouseMapper.selectWarehouseDesc(0L);
        String code = temp.getWareHouseCode()==null?"1":temp.getWareHouseCode();
        Warehouse.setWareHouseCode(String.valueOf(Integer.parseInt(code)+1));
        return warehouseMapper.insertWarehouse(Warehouse);
    }

    /**
     * 修改Warehouse
     * 
     * @param Warehouse Warehouse
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse Warehouse)
    {
        return warehouseMapper.updateWarehouse(Warehouse);
    }

    /**
     * 批量删除Warehouse
     * 
     * @param ids 需要删除的Warehouse主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByIds(String ids)
    {
        return warehouseMapper.deleteWarehouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除Warehouse信息
     * 
     * @param id Warehouse主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseById(Long id)
    {
        return warehouseMapper.deleteWarehouseById(id);
    }

    @Override
    public List<Warehouse> selectByOrganCode(String organCode) {
        List<Warehouse> Warehouses = warehouseMapper.selectByOrganCode(organCode);
        return Warehouses;
    }

    @Override
    public Warehouse selectByCode(String code) {
        return warehouseMapper.selectByCode(code);
    }

}
