package com.linkwin.activity.service.impl;

import java.util.List;

import com.linkwin.activity.domain.WechatPhoneChange;
import com.linkwin.activity.mapper.WechatPhoneChangeMapper;
import com.linkwin.activity.service.IWechatPhoneChangeService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-05
 */
@Service
public class WechatPhoneChangeServiceImpl implements IWechatPhoneChangeService
{
    @Autowired
    private WechatPhoneChangeMapper wechatPhoneChangeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public WechatPhoneChange selectWechatPhoneChangeById(Long id)
    {
        return wechatPhoneChangeMapper.selectWechatPhoneChangeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param wechatPhoneChange 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WechatPhoneChange> selectWechatPhoneChangeList(WechatPhoneChange wechatPhoneChange)
    {
        return wechatPhoneChangeMapper.selectWechatPhoneChangeList(wechatPhoneChange);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param wechatPhoneChange 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWechatPhoneChange(WechatPhoneChange wechatPhoneChange)
    {
        wechatPhoneChange.setCreateTime(DateUtils.getNowDate());
        return wechatPhoneChangeMapper.insertWechatPhoneChange(wechatPhoneChange);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param wechatPhoneChange 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWechatPhoneChange(WechatPhoneChange wechatPhoneChange)
    {
        return wechatPhoneChangeMapper.updateWechatPhoneChange(wechatPhoneChange);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWechatPhoneChangeByIds(String ids)
    {
        return wechatPhoneChangeMapper.deleteWechatPhoneChangeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWechatPhoneChangeById(Long id)
    {
        return wechatPhoneChangeMapper.deleteWechatPhoneChangeById(id);
    }
}
