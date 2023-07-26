package com.linkwin.basedata.mapper;

import com.linkwin.basedata.domain.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * warehouseMapper接口
 * 
 * @author ymding
 * @date 2021-10-26
 */
public interface WarehouseMapper 
{
    /**
     * 查询warehouse
     *
     *
     * @param id warehouse主键
     * @return warehouse
     */
    public Warehouse selectWarehouseById(Long id);

    /**
     * 查询warehouse列表
     * 
     * @param warehouse warehouse
     * @return warehouse集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增warehouse
     * 
     * @param warehouse warehouse
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改warehouse
     * 
     * @param warehouse warehouse
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 删除warehouse
     * 
     * @param id warehouse主键
     * @return 结果
     */
    public int deleteWarehouseById(Long id);

    /**
     * 批量删除warehouse
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseByIds(String[] ids);

    /**
     *
     * @param organCode
     * @return
     */
    List<Warehouse> selectByOrganCode(String organCode);

    /**
     * 根据仓库编号查询
     * @param code
     * @return
     */
    Warehouse selectByCode(String code);

    /**
     * 根据sap仓库编号查询
     * @param code
     * @return
     */
    Warehouse selectBySapCode(String code);

    public Warehouse selectWarehouseDesc (Long id);

    Integer deleteByorganCode(@Param("organCode") String organCode);


}
