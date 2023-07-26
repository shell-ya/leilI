package com.linkwin.basedata.service;

import com.linkwin.basedata.domain.Warehouse;

import java.util.List;

/**
 * WarehouseService接口
 * 
 * @author ymding
 * @date 2021-10-26
 */
public interface IWarehouseService 
{
    /**
     * 查询Warehouse
     * 
     * @param id Warehouse主键
     * @return Warehouse
     */
    public Warehouse selectWarehouseById(Long id);

    /**
     * 查询Warehouse列表
     * 
     * @param Warehouse Warehouse
     * @return Warehouse集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse Warehouse);

    /**
     * 新增Warehouse
     * 
     * @param Warehouse Warehouse
     * @return 结果
     */
    public int insertWarehouse(Warehouse Warehouse);

    /**
     * 修改Warehouse
     * 
     * @param Warehouse Warehouse
     * @return 结果
     */
    public int updateWarehouse(Warehouse Warehouse);

    /**
     * 批量删除Warehouse
     * 
     * @param ids 需要删除的Warehouse主键集合
     * @return 结果
     */
    public int deleteWarehouseByIds(String ids);

    /**
     * 删除Warehouse信息
     * 
     * @param id Warehouse主键
     * @return 结果
     */
    public int deleteWarehouseById(Long id);

    /**
     * 根据机构code查询仓库List
     * @param organCode
     * @return
     */
    List<Warehouse> selectByOrganCode(String organCode);

    /**
     * 根据仓库编码查询仓库
     * @return
     */
    Warehouse selectByCode(String code);



}
