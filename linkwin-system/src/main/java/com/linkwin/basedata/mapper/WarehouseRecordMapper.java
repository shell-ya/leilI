package com.linkwin.basedata.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.linkwin.basedata.domain.WarehouseRecord;
import org.apache.ibatis.annotations.Param;

/**
 * WarehouseRecoadMapper接口
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
public interface WarehouseRecordMapper 
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
     * 删除WarehouseRecoad
     * 
     * @param id WarehouseRecoad主键
     * @return 结果
     */
    public int deleteWarehouseRecordById(Long id);

    /**
     * 批量删除WarehouseRecoad
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseRecordByIds(String[] ids);


    List<WarehouseRecord> selectWarehouseRecordListByWareHouse(@Param("warehouseRecord") WarehouseRecord warehouseRecord, @Param("deptIds")List<Long> deptIds);
}
