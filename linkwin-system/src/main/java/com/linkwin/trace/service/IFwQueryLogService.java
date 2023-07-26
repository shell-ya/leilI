package com.linkwin.trace.service;

import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.json.JsonViewObject;
import com.linkwin.trace.domain.FwQueryLog;
import com.linkwin.vo.FwQueryResultVo;

import java.util.List;

/**
 * 防伪查询记录Service接口
 * 
 * @author ruoyi
 * @date 2022-06-02
 */
public interface IFwQueryLogService 
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
     * 批量删除防伪查询记录
     * 
     * @param ids 需要删除的防伪查询记录主键集合
     * @return 结果
     */
    public int deleteFwQueryLogByIds(String ids);

    /**
     * 删除防伪查询记录信息
     * 
     * @param id 防伪查询记录主键
     * @return 结果
     */
    public int deleteFwQueryLogById(Long id);


    /**
     * 防伪查询
     * @param code
     * @param openId
     * @param phone
     * @param address
     * @return
     */
    FwQueryResultVo fwQueryByCode(String code,String openId,String phone,String address);


    /**
     * 兑换积分
     * @param code
     * @return
     */
    JsonViewObject exchangeIntegral(String code,String phone,String address,String openId);


    /**
     * 绑定手机号
     * @param openId
     * @return
     */
    int bindPhone(String openId, String phone, String address);

    /**
     * 雷力海外版本防伪调用
     * @param code
     * @param email
     * @param phone
     * @return
     */
    FwQueryResultVo fwQueryByCode(String code, String email, String phone);

    List<FwQueryLog> selectFwQueryLogListByDeptIds(FwQueryLog fwQueryLog, List<Long> deptIds);
}
