package com.linkwin.apply.service;

import com.linkwin.apply.domain.BarCodeApply;
import com.linkwin.common.exception.ServiceException;

import java.util.List;

/**
 * 字母码申请记录Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IBarCodeApplyService 
{
    /**
     * 查询字母码申请记录
     * 
     * @param id 字母码申请记录主键
     * @return 字母码申请记录
     */
    public BarCodeApply selectBarCodeApplyById(Long id);

    /**
     * 查询字母码申请记录列表
     * 
     * @param barCodeApply 字母码申请记录
     * @return 字母码申请记录集合
     */
    public List<BarCodeApply> selectBarCodeApplyList(BarCodeApply barCodeApply);

    /**
     * 新增字母码申请记录
     * 
     * @param barCodeApply 字母码申请记录
     * @return 结果
     */
    public int insertBarCodeApply(BarCodeApply barCodeApply);

    /**
     * 修改字母码申请记录
     * 
     * @param barCodeApply 字母码申请记录
     * @return 结果
     */
    public int updateBarCodeApply(BarCodeApply barCodeApply);

    /**
     * 批量删除字母码申请记录
     * 
     * @param ids 需要删除的字母码申请记录主键集合
     * @return 结果
     */
    public int deleteBarCodeApplyByIds(String ids);

    /**
     * 删除字母码申请记录信息
     * 
     * @param id 字母码申请记录主键
     * @return 结果
     */
    public int deleteBarCodeApplyById(Long id);


    /**
     *
     */
    void export() throws ServiceException;

    void exportBoxCode() throws ServiceException;


    void test();


}
