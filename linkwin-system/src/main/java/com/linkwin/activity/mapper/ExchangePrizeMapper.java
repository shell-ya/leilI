package com.linkwin.activity.mapper;

import com.linkwin.activity.domain.ExchangePrize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 兑奖核销管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
public interface ExchangePrizeMapper 
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
     * 删除兑奖核销管理
     * 
     * @param id 兑奖核销管理主键
     * @return 结果
     */
    public int deleteExchangePrizeById(Long id);

    /**
     * 批量删除兑奖核销管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExchangePrizeByIds(String[] ids);

    /**
     * 根据兑奖码查询
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/10
     */
    ExchangePrize selectByCode(String code);


    /**
     * 根据openId 查询中奖记录
     * @param openId
     * @return
     */
    List<ExchangePrize> selectByOpenId(String openId);

    /**
     * 根据营销码查询
     * @param markCode
     * @return
     * @Author qipeng.zheng
     * @Date 20220711
     */
    ExchangePrize selectByMarkCode(@Param("markCode") String markCode);

    /**
     * 根据机构id联合查询中奖记录
     * @param exchangePrize
     * @param deptIds
     * @return
     */

    List<ExchangePrize> selectExchangePrizeListByDeptIds(@Param("exchangePrize")ExchangePrize exchangePrize,@Param("deptIds") List<Long> deptIds);
}
