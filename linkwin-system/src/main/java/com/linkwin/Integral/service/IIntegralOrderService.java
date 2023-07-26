package com.linkwin.Integral.service;

import java.util.List;
import com.linkwin.Integral.domain.IntegralOrder;

/**
 * IntegralOrderService接口
 * 
 * @author ruoyi
 * @date 2022-06-12
 */
public interface IIntegralOrderService 
{
    /**
     * 查询IntegralOrder
     * 
     * @param id IntegralOrder主键
     * @return IntegralOrder
     */
    public IntegralOrder selectIntegralOrderById(Long id);

    /**
     * 查询IntegralOrder列表
     * 
     * @param integralOrder IntegralOrder
     * @return IntegralOrder集合
     */
    public List<IntegralOrder> selectIntegralOrderList(IntegralOrder integralOrder);

    /**
     * 新增IntegralOrder
     * 
     * @param integralOrder IntegralOrder
     * @return 结果
     */
    public int insertIntegralOrder(IntegralOrder integralOrder);

    /**
     * 修改IntegralOrder
     * 
     * @param integralOrder IntegralOrder
     * @return 结果
     */
    public int updateIntegralOrder(IntegralOrder integralOrder);

    /**
     * 批量删除IntegralOrder
     * 
     * @param ids 需要删除的IntegralOrder主键集合
     * @return 结果
     */
    public int deleteIntegralOrderByIds(String ids);

    /**
     * 删除IntegralOrder信息
     * 
     * @param id IntegralOrder主键
     * @return 结果
     */
    public int deleteIntegralOrderById(Long id);
}
