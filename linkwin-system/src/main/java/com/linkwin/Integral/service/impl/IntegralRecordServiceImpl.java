package com.linkwin.Integral.service.impl;

import java.util.List;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.Integral.mapper.IntegralRecordMapper;
import com.linkwin.Integral.domain.IntegralRecord;
import com.linkwin.Integral.service.IIntegralRecordService;
import com.linkwin.common.core.text.Convert;

/**
 * IntegralRecordService业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
@Service
public class IntegralRecordServiceImpl implements IIntegralRecordService 
{
    @Autowired
    private IntegralRecordMapper integralRecordMapper;

    /**
     * 查询IntegralRecord
     * 
     * @param id IntegralRecord主键
     * @return IntegralRecord
     */
    @Override
    public IntegralRecord selectIntegralRecordById(Long id)
    {
        return integralRecordMapper.selectIntegralRecordById(id);
    }

    /**
     * 查询IntegralRecord列表
     * 
     * @param integralRecord IntegralRecord
     * @return IntegralRecord
     */
    @Override
    public List<IntegralRecord> selectIntegralRecordList(IntegralRecord integralRecord)
    {
        return integralRecordMapper.selectIntegralRecordList(integralRecord);
    }

    /**
     * 新增IntegralRecord
     * 
     * @param integralRecord IntegralRecord
     * @return 结果
     */
    @Override
    public int insertIntegralRecord(IntegralRecord integralRecord)
    {
        integralRecord.setCreateTime(DateUtils.getNowDate());
        return integralRecordMapper.insertIntegralRecord(integralRecord);
    }

    /**
     * 修改IntegralRecord
     * 
     * @param integralRecord IntegralRecord
     * @return 结果
     */
    @Override
    public int updateIntegralRecord(IntegralRecord integralRecord)
    {
        return integralRecordMapper.updateIntegralRecord(integralRecord);
    }

    /**
     * 批量删除IntegralRecord
     * 
     * @param ids 需要删除的IntegralRecord主键
     * @return 结果
     */
    @Override
    public int deleteIntegralRecordByIds(String ids)
    {
        return integralRecordMapper.deleteIntegralRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除IntegralRecord信息
     * 
     * @param id IntegralRecord主键
     * @return 结果
     */
    @Override
    public int deleteIntegralRecordById(Long id)
    {
        return integralRecordMapper.deleteIntegralRecordById(id);
    }
}
