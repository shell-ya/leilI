package com.linkwin.apply.service.impl;

import java.util.List;

import com.linkwin.apply.domain.BoxCode;
import com.linkwin.apply.mapper.BoxCodeMapper;
import com.linkwin.apply.service.IBoxCodeService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 箱码申请Service业务层处理
 * 
 * @author ruoyi
 * @date 20-05-13
 */
@Service
public class BoxCodeServiceImpl implements IBoxCodeService
{
    @Autowired
    private BoxCodeMapper boxCodeMapper;

    /**
     * 查询箱码申请
     * 
     * @param id 箱码申请主键
     * @return 箱码申请
     */
    @Override
    public BoxCode selectBoxCodeById(Long id)
    {
        return boxCodeMapper.selectBoxCodeById(id);
    }

    /**
     * 查询箱码申请列表
     * 
     * @param boxCode 箱码申请
     * @return 箱码申请
     */
    @Override
    public List<BoxCode> selectBoxCodeList(BoxCode boxCode)
    {
        return boxCodeMapper.selectBoxCodeList(boxCode);
    }

    /**
     * 新增箱码申请
     * 
     * @param boxCode 箱码申请
     * @return 结果
     */
    @Override
    public int insertBoxCode(BoxCode boxCode)
    {
        boxCode.setCreateTime(DateUtils.getNowDate());
        return boxCodeMapper.insertBoxCode(boxCode);
    }

    /**
     * 修改箱码申请
     * 
     * @param boxCode 箱码申请
     * @return 结果
     */
    @Override
    public int updateBoxCode(BoxCode boxCode)
    {
        return boxCodeMapper.updateBoxCode(boxCode);
    }

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的箱码申请主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodeByIds(String ids)
    {
        return boxCodeMapper.deleteBoxCodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除箱码申请信息
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodeById(Long id)
    {
        return boxCodeMapper.deleteBoxCodeById(id);
    }
}
