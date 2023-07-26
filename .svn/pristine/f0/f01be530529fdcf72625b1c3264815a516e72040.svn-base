package com.linkwin.basedata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.basedata.mapper.WarehouseRecordMapper;
import com.linkwin.basedata.domain.WarehouseRecord;
import com.linkwin.basedata.service.IWarehouseRecordService;
import com.linkwin.common.core.text.Convert;

/**
 * WarehouseRecoadService业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
@Service
public class WarehouseRecordServiceImpl implements IWarehouseRecordService 
{
    @Autowired
    private WarehouseRecordMapper WarehouseRecordMapper;

    /**
     * 查询WarehouseRecoad
     * 
     * @param id WarehouseRecoad主键
     * @return WarehouseRecoad
     */
    @Override
    public WarehouseRecord selectWarehouseRecordById(Long id)
    {
        return WarehouseRecordMapper.selectWarehouseRecordById(id);
    }

    /**
     * 查询WarehouseRecoad列表
     * 
     * @param WarehouseRecord WarehouseRecoad
     * @return WarehouseRecoad
     */
    @Override
    public List<WarehouseRecord> selectWarehouseRecordList(WarehouseRecord WarehouseRecord)
    {
        return WarehouseRecordMapper.selectWarehouseRecordList(WarehouseRecord);
    }

    /**
     * 新增WarehouseRecoad
     * 
     * @param WarehouseRecord WarehouseRecoad
     * @return 结果
     */
    @Override
    public int insertWarehouseRecord(WarehouseRecord WarehouseRecord)
    {
        return WarehouseRecordMapper.insertWarehouseRecord(WarehouseRecord);
    }

    /**
     * 修改WarehouseRecoad
     * 
     * @param WarehouseRecord WarehouseRecoad
     * @return 结果
     */
    @Override
    public int updateWarehouseRecord(WarehouseRecord WarehouseRecord)
    {
        return WarehouseRecordMapper.updateWarehouseRecord(WarehouseRecord);
    }

    /**
     * 批量删除WarehouseRecoad
     * 
     * @param ids 需要删除的WarehouseRecoad主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseRecordByIds(String ids)
    {
        return WarehouseRecordMapper.deleteWarehouseRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除WarehouseRecoad信息
     * 
     * @param id WarehouseRecoad主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseRecordById(Long id)
    {
        return WarehouseRecordMapper.deleteWarehouseRecordById(id);
    }

    @Override
    public List<WarehouseRecord> selectWarehouseRecordListByWareHouse(WarehouseRecord warehouseRecord, List<Long> deptIds) {
        return WarehouseRecordMapper.selectWarehouseRecordListByWareHouse(warehouseRecord,deptIds);
    }
}
