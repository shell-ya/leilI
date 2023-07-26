package com.linkwin.Integral.service.impl;

import java.util.List;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.Integral.mapper.IntegralOrderMapper;
import com.linkwin.Integral.domain.IntegralOrder;
import com.linkwin.Integral.service.IIntegralOrderService;
import com.linkwin.common.core.text.Convert;

/**
 * IntegralOrderService业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-12
 */
@Service
public class IntegralOrderServiceImpl implements IIntegralOrderService 
{
    @Autowired
    private IntegralOrderMapper integralOrderMapper;

    /**
     * 查询IntegralOrder
     * 
     * @param id IntegralOrder主键
     * @return IntegralOrder
     */
    @Override
    public IntegralOrder selectIntegralOrderById(Long id)
    {
        return integralOrderMapper.selectIntegralOrderById(id);
    }

    /**
     * 查询IntegralOrder列表
     * 
     * @param integralOrder IntegralOrder
     * @return IntegralOrder
     */
    @Override
    public List<IntegralOrder> selectIntegralOrderList(IntegralOrder integralOrder)
    {
        return integralOrderMapper.selectIntegralOrderList(integralOrder);
    }

    /**
     * 新增IntegralOrder
     * 
     * @param integralOrder IntegralOrder
     * @return 结果
     */
    @Override
    public int insertIntegralOrder(IntegralOrder integralOrder)
    {
        integralOrder.setCreateTime(DateUtils.getNowDate());
        return integralOrderMapper.insertIntegralOrder(integralOrder);
    }

    /**
     * 修改IntegralOrder
     * 
     * @param integralOrder IntegralOrder
     * @return 结果
     */
    @Override
    public int updateIntegralOrder(IntegralOrder integralOrder)
    {
        return integralOrderMapper.updateIntegralOrder(integralOrder);
    }

    /**
     * 批量删除IntegralOrder
     * 
     * @param ids 需要删除的IntegralOrder主键
     * @return 结果
     */
    @Override
    public int deleteIntegralOrderByIds(String ids)
    {
        return integralOrderMapper.deleteIntegralOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除IntegralOrder信息
     * 
     * @param id IntegralOrder主键
     * @return 结果
     */
    @Override
    public int deleteIntegralOrderById(Long id)
    {
        return integralOrderMapper.deleteIntegralOrderById(id);
    }
}
