package com.linkwin.activity.service;

import com.linkwin.activity.domain.ExchangePrize;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.json.JsonViewObject;

import java.util.List;

/**
 * 兑奖核销管理Service接口
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
public interface IExchangePrizeService 
{
    /**
     * 查询兑奖核销管理
     * 
     * @param id 兑奖核销管理主键
     * @return 兑奖核销管理
     */
    public ExchangePrize selectExchangePrizeById(Long id);

    /**
     * 查询兑奖核销管理列表
     * 
     * @param exchangePrize 兑奖核销管理
     * @return 兑奖核销管理集合
     */
    public List<ExchangePrize> selectExchangePrizeList(ExchangePrize exchangePrize);

    /**
     * 新增兑奖核销管理
     * 
     * @param exchangePrize 兑奖核销管理
     * @return 结果
     */
    public int insertExchangePrize(ExchangePrize exchangePrize);

    /**
     * 修改兑奖核销管理
     * 
     * @param exchangePrize 兑奖核销管理
     * @return 结果
     */
    public int updateExchangePrize(ExchangePrize exchangePrize);

    /**
     * 批量删除兑奖核销管理
     * 
     * @param ids 需要删除的兑奖核销管理主键集合
     * @return 结果
     */
    public int deleteExchangePrizeByIds(String ids);

    /**
     * 删除兑奖核销管理信息
     * 
     * @param id 兑奖核销管理主键
     * @return 结果
     */
    public int deleteExchangePrizeById(Long id);

    /**
     * 经销商兑奖
     * @param exchangePrize
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/10
     */
    JsonViewObject exchange(ExchangePrize exchangePrize, SysUser user) throws ServiceException;

    /**
     * 根据中奖码查询
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/14
     */
    ExchangePrize selectByCode(String code);


    /**
     * 根据openId查询中奖记录
     * @param openId
     * @return
     */
    List<ExchangePrize> selectByOpenId(String openId);

    /**
     * 根据机构id联合查询对应的中奖记录
     * @param exchangePrize
     * @param deptIds
     * @return
     */

    List<ExchangePrize> selectExchangePrizeListByDeptIds(ExchangePrize exchangePrize, List<Long> deptIds);
}
