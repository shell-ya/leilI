package com.linkwin.basedata.service;

import java.util.List;
import com.linkwin.basedata.domain.WarehouseRecord;

/**
 * WarehouseRecoadService接口
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
public interface IWarehouseRecordService 
{
    /**
     * 查询WarehouseRecoad
     * 
     * @param id WarehouseRecoad主键
     * @return WarehouseRecoad
     */
    public WarehouseRecord selectWarehouseRecordById(Long id);

    /**
     * 查询WarehouseRecoad列表
     * 
     * @param WarehouseRecord WarehouseRecoad
     * @return WarehouseRecoad集合
     */
    public List<WarehouseRecord> selectWarehouseRecordList(WarehouseRecord WarehouseRecord);

    /**
     * 新增WarehouseRecoad
     * 
     * @param WarehouseRecord WarehouseRecoad
     * @return 结果
     */
    public int insertWarehouseRecord(WarehouseRecord WarehouseRecord);

    /**
     * 修改WarehouseRecoad
     * 
     * @param WarehouseRecord WarehouseRecoad
     * @return 结果
     */
    public int updateWarehouseRecord(WarehouseRecord WarehouseRecord);

    /**
     * 批量删除WarehouseRecoad
     * 
     * @param ids 需要删除的WarehouseRecoad主键集合
     * @return 结果
     */
    public int deleteWarehouseRecordByIds(String ids);

    /**
     * 删除WarehouseRecoad信息
     * 
     * @param id WarehouseRecoad主键
     * @return 结果
     */
    public int deleteWarehouseRecordById(Long id);

    List<WarehouseRecord> selectWarehouseRecordListByWareHouse(WarehouseRecord warehouseRecord, List<Long> deptIds);
}
