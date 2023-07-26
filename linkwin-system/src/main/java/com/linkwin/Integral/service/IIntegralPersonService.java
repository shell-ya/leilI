package com.linkwin.Integral.service;

import java.security.SecureRandom;
import java.util.List;
import com.linkwin.Integral.domain.IntegralPerson;
import com.linkwin.common.exception.ServiceException;

/**
 * IntegralPersonService接口
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
public interface IIntegralPersonService 
{
    /**
     * 查询IntegralPerson
     * 
     * @param id IntegralPerson主键
     * @return IntegralPerson
     */
    public IntegralPerson selectIntegralPersonById(Long id);



    /**
     * 查询IntegralPerson列表
     * 
     * @param integralPerson IntegralPerson
     * @return IntegralPerson集合
     */
    public List<IntegralPerson> selectIntegralPersonList(IntegralPerson integralPerson);

    /**
     * 新增IntegralPerson
     * 
     * @param integralPerson IntegralPerson
     * @return 结果
     */
    public int insertIntegralPerson(IntegralPerson integralPerson);

    /**
     * 修改IntegralPerson
     * 
     * @param integralPerson IntegralPerson
     * @return 结果
     */
    public int updateIntegralPerson(IntegralPerson integralPerson);

    /**
     * 批量删除IntegralPerson
     * 
     * @param ids 需要删除的IntegralPerson主键集合
     * @return 结果
     */
    public int deleteIntegralPersonByIds(String ids);

    /**
     * 删除IntegralPerson信息
     * 
     * @param id IntegralPerson主键
     * @return 结果
     */
    public int deleteIntegralPersonById(Long id);

    public IntegralPerson selectIntegralPersonByphoneNumber(String phoneNumber);

    /**
     * 增加积分及积分变动记录
     * @param integralPerson
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/16
     */
    IntegralPerson insertPersonAndRecord(IntegralPerson integralPerson,String code) throws ServiceException;

    /**
     * 根据微信号查询信息
     * @param openId
     * @return
     */
    IntegralPerson selectByOpenId(String openId);

    /**
     * 根据手机号查询
     * @param phone
     * @return
     */
    IntegralPerson selectByPhone(String phone);





}
