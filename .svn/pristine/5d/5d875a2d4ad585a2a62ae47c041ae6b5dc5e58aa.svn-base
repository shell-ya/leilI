package com.linkwin.trace.service.impl;

import java.util.List;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.trace.domain.ConsumerLog;
import com.linkwin.trace.mapper.ConsumerLogMapper;
import com.linkwin.trace.service.IConsumerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 消费者信息日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
@Service
public class ConsumerLogServiceImpl implements IConsumerLogService
{
    @Autowired
    private ConsumerLogMapper consumerLogMapper;

    /**
     * 查询消费者信息日志
     * 
     * @param id 消费者信息日志主键
     * @return 消费者信息日志
     */
    @Override
    public ConsumerLog selectConsumerLogById(Long id)
    {
        return consumerLogMapper.selectConsumerLogById(id);
    }

    /**
     * 查询消费者信息日志列表
     * 
     * @param consumerLog 消费者信息日志
     * @return 消费者信息日志
     */
    @Override
    public List<ConsumerLog> selectConsumerLogList(ConsumerLog consumerLog)
    {
        return consumerLogMapper.selectConsumerLogList(consumerLog);
    }

    /**
     * 新增消费者信息日志
     * 
     * @param consumerLog 消费者信息日志
     * @return 结果
     */
    @Override
    public int insertConsumerLog(ConsumerLog consumerLog)
    {
        consumerLog.setCreateTime(DateUtils.getNowDate());
        return consumerLogMapper.insertConsumerLog(consumerLog);
    }

    /**
     * 修改消费者信息日志
     * 
     * @param consumerLog 消费者信息日志
     * @return 结果
     */
    @Override
    public int updateConsumerLog(ConsumerLog consumerLog)
    {
        return consumerLogMapper.updateConsumerLog(consumerLog);
    }

    /**
     * 批量删除消费者信息日志
     * 
     * @param ids 需要删除的消费者信息日志主键
     * @return 结果
     */
    @Override
    public int deleteConsumerLogByIds(String ids)
    {
        return consumerLogMapper.deleteConsumerLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消费者信息日志信息
     * 
     * @param id 消费者信息日志主键
     * @return 结果
     */
    @Override
    public int deleteConsumerLogById(Long id)
    {
        return consumerLogMapper.deleteConsumerLogById(id);
    }

    @Override
    public List<ConsumerLog> selectConsumerLogByDeptId(ConsumerLog consumerLog, List<Long> deptIds) {
        return consumerLogMapper.selectConsumerLogByDeptId(consumerLog,deptIds);
    }
}
