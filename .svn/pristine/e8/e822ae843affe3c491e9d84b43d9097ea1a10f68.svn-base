package com.linkwin.activity.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.linkwin.activity.domain.LuckdrawPrize;
import com.linkwin.activity.mapper.LuckdrawPrizeMapper;
import com.linkwin.activity.service.ILuckdrawPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Service
public class LuckdrawPrizeServiceImpl implements ILuckdrawPrizeService
{
    @Autowired
    private LuckdrawPrizeMapper luckdrawPrizeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public LuckdrawPrize selectLuckdrawPrizeById(Long id)
    {
        return luckdrawPrizeMapper.selectLuckdrawPrizeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param luckdrawPrize 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<LuckdrawPrize> selectLuckdrawPrizeList(LuckdrawPrize luckdrawPrize)
    {
        return luckdrawPrizeMapper.selectLuckdrawPrizeList(luckdrawPrize);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param luckdrawPrize 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertLuckdrawPrize(LuckdrawPrize luckdrawPrize)
    {
        int i = luckdrawPrizeMapper.insertLuckdrawPrize(luckdrawPrize);

        luckdrawPrizeMapper.updateSumRatenumById(luckdrawPrize.getActivityid());

        return i;
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param luckdrawPrize 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateLuckdrawPrize(LuckdrawPrize luckdrawPrize)
    {
        int i=luckdrawPrizeMapper.updateLuckdrawPrize(luckdrawPrize);
        luckdrawPrizeMapper.updateSumRatenumById(luckdrawPrize.getActivityid());

        return i;
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLuckdrawPrizeByIds(String ids)
    {
        int i =luckdrawPrizeMapper.deleteLuckdrawPrizeByIds(Convert.toStrArray(ids));

        return i;
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLuckdrawPrizeById(Long id)
    {
        Long a =luckdrawPrizeMapper.selectLuckdrawPrizeById(id).getActivityid();
        int i = luckdrawPrizeMapper.deleteLuckdrawPrizeById(id);

        luckdrawPrizeMapper.updateSumRatenumById(a);
        return i;

    }
}
