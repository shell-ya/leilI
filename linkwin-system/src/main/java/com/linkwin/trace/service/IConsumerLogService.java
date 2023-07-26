package com.linkwin.trace.service;

import com.linkwin.trace.domain.ConsumerLog;

import java.util.List;

/**
 * 消费者信息日志Service接口
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public interface IConsumerLogService 
{
    /**
     * 查询消费者信息日志
     * 
     * @param id 消费者信息日志主键
     * @return 消费者信息日志
     */
    public ConsumerLog selectConsumerLogById(Long id);

    /**
     * 查询消费者信息日志列表
     * 
     * @param consumerLog 消费者信息日志
     * @return 消费者信息日志集合
     */
    public List<ConsumerLog> selectConsumerLogList(ConsumerLog consumerLog);

    /**
     * 新增消费者信息日志
     * 
     * @param consumerLog 消费者信息日志
     * @return 结果
     */
    public int insertConsumerLog(ConsumerLog consumerLog);

    /**
     * 修改消费者信息日志
     * 
     * @param consumerLog 消费者信息日志
     * @return 结果
     */
    public int updateConsumerLog(ConsumerLog consumerLog);

    /**
     * 批量删除消费者信息日志
     * 
     * @param ids 需要删除的消费者信息日志主键集合
     * @return 结果
     */
    public int deleteConsumerLogByIds(String ids);

    /**
     * 删除消费者信息日志信息
     * 
     * @param id 消费者信息日志主键
     * @return 结果
     */
    public int deleteConsumerLogById(Long id);

    List<ConsumerLog> selectConsumerLogByDeptId(ConsumerLog consumerLog, List<Long> deptIds);
}
