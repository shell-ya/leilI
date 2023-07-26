package com.linkwin.trace.mapper;

import com.linkwin.trace.domain.FwQueryLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 防伪查询记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-02
 */
public interface FwQueryLogMapper 
{
    /**
     * 查询防伪查询记录
     * 
     * @param id 防伪查询记录主键
     * @return 防伪查询记录
     */
    public FwQueryLog selectFwQueryLogById(Long id);

    /**
     * 查询防伪查询记录列表
     * 
     * @param fwQueryLog 防伪查询记录
     * @return 防伪查询记录集合
     */
    public List<FwQueryLog> selectFwQueryLogList(FwQueryLog fwQueryLog);

    /**
     * 新增防伪查询记录
     * 
     * @param fwQueryLog 防伪查询记录
     * @return 结果
     */
    public int insertFwQueryLog(FwQueryLog fwQueryLog);

    /**
     * 修改防伪查询记录
     * 
     * @param fwQueryLog 防伪查询记录
     * @return 结果
     */
    public int updateFwQueryLog(FwQueryLog fwQueryLog);

    /**
     * 删除防伪查询记录
     * 
     * @param id 防伪查询记录主键
     * @return 结果
     */
    public int deleteFwQueryLogById(Long id);

    /**
     * 批量删除防伪查询记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFwQueryLogByIds(String[] ids);

    /**
     * 查询防伪查询日志
     * @param pdCode  产品编码
     * @param code
     * @param codeType
     * @return
     * @Author qi[eng.zheng
     * @Aate 2022/6/8
     */
    FwQueryLog selectByCode(@Param("pdCode") String pdCode, @Param("code") String code, @Param("codeType") String codeType);


    List<FwQueryLog> selectFwQueryLogListByDeptIds(@Param("fwQueryLog") FwQueryLog fwQueryLog,@Param("deptIds") List<Long> deptIds);
}
