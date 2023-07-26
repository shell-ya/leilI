package com.linkwin.apply.service.impl;

import java.util.List;

import com.linkwin.apply.domain.BoxCodeApply;
import com.linkwin.apply.mapper.BoxCodeApplyMapper;
import com.linkwin.apply.service.IBoxCodeApplyService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
@Service
public class BoxCodeApplyServiceImpl implements IBoxCodeApplyService
{
    @Autowired
    private BoxCodeApplyMapper boxCodeApplyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BoxCodeApply selectBoxCodeApplyById(Long id)
    {
        return boxCodeApplyMapper.selectBoxCodeApplyById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param boxCodeApply 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BoxCodeApply> selectBoxCodeApplyList(BoxCodeApply boxCodeApply)
    {
        return boxCodeApplyMapper.selectBoxCodeApplyList(boxCodeApply);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param boxCodeApply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBoxCodeApply(BoxCodeApply boxCodeApply)
    {
        boxCodeApply.setCreateTime(DateUtils.getNowDate());
        return boxCodeApplyMapper.insertBoxCodeApply(boxCodeApply);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param boxCodeApply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBoxCodeApply(BoxCodeApply boxCodeApply)
    {
        return boxCodeApplyMapper.updateBoxCodeApply(boxCodeApply);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodeApplyByIds(String ids)
    {
        return boxCodeApplyMapper.deleteBoxCodeApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodeApplyById(Long id)
    {
        return boxCodeApplyMapper.deleteBoxCodeApplyById(id);
    }
}
