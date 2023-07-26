package com.linkwin.Integral.mapper;

import java.util.List;
import com.linkwin.Integral.domain.IntegralPerson;

/**
 * IntegralPersonMapper接口
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
public interface IntegralPersonMapper 
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
     * 删除IntegralPerson
     * 
     * @param id IntegralPerson主键
     * @return 结果
     */
    public int deleteIntegralPersonById(Long id);

    /**
     * 批量删除IntegralPerson
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIntegralPersonByIds(String[] ids);


    public IntegralPerson selectIntegralPersonByphoneNumber(String phoneNumber);

    /**
     * 根据电话查找积分信息
     * @param phone
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/16
     */
    IntegralPerson selectByPhone(String phone);

    /**
     * 根据微信号查询
     * @param openId
     * @return
     */
    IntegralPerson selectByOpenId(String openId);

}



