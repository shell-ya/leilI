package com.linkwin.activity.service.impl;

import java.util.List;

import com.linkwin.activity.domain.ExchangeIntegral;
import com.linkwin.activity.mapper.ExchangeIntegralMapper;
import com.linkwin.activity.service.IExchangeIntegralService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 兑换积分记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-14
 */
@Service
public class ExchangeIntegralServiceImpl implements IExchangeIntegralService
{
    @Autowired
    private ExchangeIntegralMapper exchangeIntegralMapper;

    /**
     * 查询兑换积分记录
     * 
     * @param id 兑换积分记录主键
     * @return 兑换积分记录
     */
    @Override
    public ExchangeIntegral selectExchangeIntegralById(Long id)
    {
        return exchangeIntegralMapper.selectExchangeIntegralById(id);
    }

    /**
     * 查询兑换积分记录列表
     * 
     * @param exchangeIntegral 兑换积分记录
     * @return 兑换积分记录
     */
    @Override
    public List<ExchangeIntegral> selectExchangeIntegralList(ExchangeIntegral exchangeIntegral)
    {
        return exchangeIntegralMapper.selectExchangeIntegralList(exchangeIntegral);
    }

    /**
     * 新增兑换积分记录
     * 
     * @param exchangeIntegral 兑换积分记录
     * @return 结果
     */
    @Override
    public int insertExchangeIntegral(ExchangeIntegral exchangeIntegral)
    {
        exchangeIntegral.setCreateTime(DateUtils.getNowDate());
        return exchangeIntegralMapper.insertExchangeIntegral(exchangeIntegral);
    }

    /**
     * 修改兑换积分记录
     * 
     * @param exchangeIntegral 兑换积分记录
     * @return 结果
     */
    @Override
    public int updateExchangeIntegral(ExchangeIntegral exchangeIntegral)
    {
        return exchangeIntegralMapper.updateExchangeIntegral(exchangeIntegral);
    }

    /**
     * 批量删除兑换积分记录
     * 
     * @param ids 需要删除的兑换积分记录主键
     * @return 结果
     */
    @Override
    public int deleteExchangeIntegralByIds(String ids)
    {
        return exchangeIntegralMapper.deleteExchangeIntegralByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除兑换积分记录信息
     * 
     * @param id 兑换积分记录主键
     * @return 结果
     */
    @Override
    public int deleteExchangeIntegralById(Long id)
    {
        return exchangeIntegralMapper.deleteExchangeIntegralById(id);
    }

    @Override
    public ExchangeIntegral selectByMarkCode(String markCode) {
        return exchangeIntegralMapper.selectByMarkCode(markCode);
    }
}
