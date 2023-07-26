package com.linkwin.activity.service.impl;

import java.util.List;

import com.linkwin.activity.domain.CodeActivityLog;
import com.linkwin.activity.mapper.CodeActivityLogMapper;
import com.linkwin.activity.service.ICodeActivityLogService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 条码参加活动记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
@Service
public class CodeActivityLogServiceImpl implements ICodeActivityLogService
{
    @Autowired(required = false)
    private CodeActivityLogMapper codeActivityLogMapper;

    /**
     * 查询条码参加活动记录
     * 
     * @param id 条码参加活动记录主键
     * @return 条码参加活动记录
     */
    @Override
    public CodeActivityLog selectCodeActivityLogById(Long id)
    {
        return codeActivityLogMapper.selectCodeActivityLogById(id);
    }

    /**
     * 查询条码参加活动记录列表
     * 
     * @param codeActivityLog 条码参加活动记录
     * @return 条码参加活动记录
     */
    @Override
    public List<CodeActivityLog> selectCodeActivityLogList(CodeActivityLog codeActivityLog)
    {
        return codeActivityLogMapper.selectCodeActivityLogList(codeActivityLog);
    }

    /**
     * 新增条码参加活动记录
     * 
     * @param codeActivityLog 条码参加活动记录
     * @return 结果
     */
    @Override
    public int insertCodeActivityLog(CodeActivityLog codeActivityLog)
    {
        codeActivityLog.setCreateTime(DateUtils.getNowDate());
        return codeActivityLogMapper.insertCodeActivityLog(codeActivityLog);
    }

    /**
     * 修改条码参加活动记录
     * 
     * @param codeActivityLog 条码参加活动记录
     * @return 结果
     */
    @Override
    public int updateCodeActivityLog(CodeActivityLog codeActivityLog)
    {
        return codeActivityLogMapper.updateCodeActivityLog(codeActivityLog);
    }

    /**
     * 批量删除条码参加活动记录
     * 
     * @param ids 需要删除的条码参加活动记录主键
     * @return 结果
     */
    @Override
    public int deleteCodeActivityLogByIds(String ids)
    {
        return codeActivityLogMapper.deleteCodeActivityLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除条码参加活动记录信息
     * 
     * @param id 条码参加活动记录主键
     * @return 结果
     */
    @Override
    public int deleteCodeActivityLogById(Long id)
    {
        return codeActivityLogMapper.deleteCodeActivityLogById(id);
    }
}
