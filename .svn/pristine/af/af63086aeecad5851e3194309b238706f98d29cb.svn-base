package com.linkwin.apply.service.impl;

import java.util.List;

import com.linkwin.apply.domain.SubCode;
import com.linkwin.apply.mapper.SubCodeMapper;
import com.linkwin.apply.service.ISubCodeService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 箱码申请Service业务层处理
 * 
 * @author ruoyi
 * @date 20-05-19
 */
@Service
public class SubCodeServiceImpl implements ISubCodeService 
{
    @Autowired
    private SubCodeMapper subCodeMapper;

    /**
     * 查询箱码申请
     * 
     * @param id 箱码申请主键
     * @return 箱码申请
     */
    @Override
    public SubCode selectSubCodeById(Long id)
    {
        return subCodeMapper.selectSubCodeById(id);
    }

    /**
     * 查询箱码申请列表
     * 
     * @param subCode 箱码申请
     * @return 箱码申请
     */
    @Override
    public List<SubCode> selectSubCodeList(SubCode subCode)
    {
        return subCodeMapper.selectSubCodeList(subCode);
    }

    /**
     * 新增箱码申请
     * 
     * @param subCode 箱码申请
     * @return 结果
     */
    @Override
    public int insertSubCode(SubCode subCode)
    {
        subCode.setCreateTime(DateUtils.getNowDate());
        return subCodeMapper.insertSubCode(subCode);
    }

    /**
     * 修改箱码申请
     * 
     * @param subCode 箱码申请
     * @return 结果
     */
    @Override
    public int updateSubCode(SubCode subCode)
    {
        return subCodeMapper.updateSubCode(subCode);
    }

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的箱码申请主键
     * @return 结果
     */
    @Override
    public int deleteSubCodeByIds(String ids)
    {
        return subCodeMapper.deleteSubCodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除箱码申请信息
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    @Override
    public int deleteSubCodeById(Long id)
    {
        return subCodeMapper.deleteSubCodeById(id);
    }
}
