package com.linkwin.trace.mapper;

import com.linkwin.trace.domain.ConsumerLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消费者信息日志Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public interface ConsumerLogMapper 
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
     * 删除消费者信息日志
     * 
     * @param id 消费者信息日志主键
     * @return 结果
     */
    public int deleteConsumerLogById(Long id);

    /**
     * 批量删除消费者信息日志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteConsumerLogByIds(String[] ids);

    /**
     * 批量新增消费者日志
     * @param dataList
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/26
     */
    int batchInsert(@Param("dataList") List<ConsumerLog> dataList);

    List<ConsumerLog> selectConsumerLogByDeptId(@Param("consumerLog") ConsumerLog consumerLog, @Param("deptIds") List<Long> deptIds);
}
