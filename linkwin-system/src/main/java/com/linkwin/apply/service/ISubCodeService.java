package com.linkwin.apply.service;

import com.linkwin.apply.domain.SubCode;

import java.util.List;

/**
 * 箱码申请Service接口
 * 
 * @author ruoyi
 * @date 20-05-19
 */
public interface ISubCodeService 
{
    /**
     * 查询箱码申请
     * 
     * @param id 箱码申请主键
     * @return 箱码申请
     */
    public SubCode selectSubCodeById(Long id);

    /**
     * 查询箱码申请列表
     * 
     * @param subCode 箱码申请
     * @return 箱码申请集合
     */
    public List<SubCode> selectSubCodeList(SubCode subCode);

    /**
     * 新增箱码申请
     * 
     * @param subCode 箱码申请
     * @return 结果
     */
    public int insertSubCode(SubCode subCode);

    /**
     * 修改箱码申请
     * 
     * @param subCode 箱码申请
     * @return 结果
     */
    public int updateSubCode(SubCode subCode);

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的箱码申请主键集合
     * @return 结果
     */
    public int deleteSubCodeByIds(String ids);

    /**
     * 删除箱码申请信息
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    public int deleteSubCodeById(Long id);
}
