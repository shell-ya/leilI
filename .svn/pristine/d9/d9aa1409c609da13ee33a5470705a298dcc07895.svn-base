package com.linkwin.activity.mapper;

import com.linkwin.activity.domain.ExchangeIntegral;

import java.util.List;

/**
 * 兑换积分记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-14
 */
public interface ExchangeIntegralMapper 
{
    /**
     * 查询兑换积分记录
     * 
     * @param id 兑换积分记录主键
     * @return 兑换积分记录
     */
    public ExchangeIntegral selectExchangeIntegralById(Long id);

    /**
     * 查询兑换积分记录列表
     * 
     * @param exchangeIntegral 兑换积分记录
     * @return 兑换积分记录集合
     */
    public List<ExchangeIntegral> selectExchangeIntegralList(ExchangeIntegral exchangeIntegral);

    /**
     * 新增兑换积分记录
     * 
     * @param exchangeIntegral 兑换积分记录
     * @return 结果
     */
    public int insertExchangeIntegral(ExchangeIntegral exchangeIntegral);

    /**
     * 修改兑换积分记录
     * 
     * @param exchangeIntegral 兑换积分记录
     * @return 结果
     */
    public int updateExchangeIntegral(ExchangeIntegral exchangeIntegral);

    /**
     * 删除兑换积分记录
     * 
     * @param id 兑换积分记录主键
     * @return 结果
     */
    public int deleteExchangeIntegralById(Long id);

    /**
     * 批量删除兑换积分记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExchangeIntegralByIds(String[] ids);


    /**
     * 根据营销码查询兑换积分记录
     * @param markCode
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/16
     */
    ExchangeIntegral selectByMarkCode(String markCode);

}
