package com.linkwin.apply.service;

import com.linkwin.apply.domain.BarCode;

import java.util.List;

/**
 * 箱码申请Service接口
 * 
 * @author ruoyi
 * @date 20-05-19
 */
public interface IBarCodeService 
{
    /**
     * 查询箱码申请
     * 
     * @param id 箱码申请主键
     * @return 箱码申请
     */
    public BarCode selectBarCodeById(Long id);

    /**
     * 查询箱码申请列表
     * 
     * @param barCode 箱码申请
     * @return 箱码申请集合
     */
    public List<BarCode> selectBarCodeList(BarCode barCode);

    /**
     * 新增箱码申请
     * 
     * @param barCode 箱码申请
     * @return 结果
     */
    public int insertBarCode(BarCode barCode);

    /**
     * 修改箱码申请
     * 
     * @param barCode 箱码申请
     * @return 结果
     */
    public int updateBarCode(BarCode barCode);

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的箱码申请主键集合
     * @return 结果
     */
    public int deleteBarCodeByIds(String ids);

    /**
     * 删除箱码申请信息
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    public int deleteBarCodeById(Long id);
}
