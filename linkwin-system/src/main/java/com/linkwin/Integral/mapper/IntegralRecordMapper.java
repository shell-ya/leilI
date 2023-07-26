package com.linkwin.Integral.mapper;

import java.util.List;
import com.linkwin.Integral.domain.IntegralRecord;

/**
 * IntegralRecordMapper接口
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
public interface IntegralRecordMapper 
{
    /**
     * 查询IntegralRecord
     * 
     * @param id IntegralRecord主键
     * @return IntegralRecord
     */
    public IntegralRecord selectIntegralRecordById(Long id);

    /**
     * 查询IntegralRecord列表
     * 
     * @param integralRecord IntegralRecord
     * @return IntegralRecord集合
     */
    public List<IntegralRecord> selectIntegralRecordList(IntegralRecord integralRecord);

    /**
     * 新增IntegralRecord
     * 
     * @param integralRecord IntegralRecord
     * @return 结果
     */
    public int insertIntegralRecord(IntegralRecord integralRecord);

    /**
     * 修改IntegralRecord
     * 
     * @param integralRecord IntegralRecord
     * @return 结果
     */
    public int updateIntegralRecord(IntegralRecord integralRecord);

    /**
     * 删除IntegralRecord
     * 
     * @param id IntegralRecord主键
     * @return 结果
     */
    public int deleteIntegralRecordById(Long id);

    /**
     * 批量删除IntegralRecord
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIntegralRecordByIds(String[] ids);
}
