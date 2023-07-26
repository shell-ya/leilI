package com.linkwin.activity.mapper;

import com.linkwin.activity.domain.LuckdrawPrize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public interface LuckdrawPrizeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public LuckdrawPrize selectLuckdrawPrizeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param luckdrawPrize 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<LuckdrawPrize> selectLuckdrawPrizeList(LuckdrawPrize luckdrawPrize);

    /**
     * 新增【请填写功能名称】
     * 
     * @param luckdrawPrize 【请填写功能名称】
     * @return 结果
     */
    public int insertLuckdrawPrize(LuckdrawPrize luckdrawPrize);

    /**
     * 修改【请填写功能名称】
     * 
     * @param luckdrawPrize 【请填写功能名称】
     * @return 结果
     */
    public int updateLuckdrawPrize(LuckdrawPrize luckdrawPrize);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteLuckdrawPrizeById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLuckdrawPrizeByIds(String[] ids);

    /**
     * 更新奖品剩余数量
     * @param id
     * @return
     * @Author qipeng.zheng
     * @Date 20220/09/06
     */
    int updateReMainNum(Long id);

    int updateSumRatenumById(@Param("activityid") Long activityid);

}
