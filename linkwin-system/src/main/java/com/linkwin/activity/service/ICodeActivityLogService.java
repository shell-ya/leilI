package com.linkwin.activity.service;

import com.linkwin.activity.domain.CodeActivityLog;

import java.util.List;

/**
 * 条码参加活动记录Service接口
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
public interface ICodeActivityLogService 
{
    /**
     * 查询条码参加活动记录
     * 
     * @param id 条码参加活动记录主键
     * @return 条码参加活动记录
     */
    public CodeActivityLog selectCodeActivityLogById(Long id);

    /**
     * 查询条码参加活动记录列表
     * 
     * @param codeActivityLog 条码参加活动记录
     * @return 条码参加活动记录集合
     */
    public List<CodeActivityLog> selectCodeActivityLogList(CodeActivityLog codeActivityLog);

    /**
     * 新增条码参加活动记录
     * 
     * @param codeActivityLog 条码参加活动记录
     * @return 结果
     */
    public int insertCodeActivityLog(CodeActivityLog codeActivityLog);

    /**
     * 修改条码参加活动记录
     * 
     * @param codeActivityLog 条码参加活动记录
     * @return 结果
     */
    public int updateCodeActivityLog(CodeActivityLog codeActivityLog);

    /**
     * 批量删除条码参加活动记录
     * 
     * @param ids 需要删除的条码参加活动记录主键集合
     * @return 结果
     */
    public int deleteCodeActivityLogByIds(String ids);

    /**
     * 删除条码参加活动记录信息
     * 
     * @param id 条码参加活动记录主键
     * @return 结果
     */
    public int deleteCodeActivityLogById(Long id);
}
