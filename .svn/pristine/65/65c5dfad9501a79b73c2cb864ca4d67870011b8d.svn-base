package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BarCodeApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字母码申请记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface BarCodeApplyMapper 
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
     * 删除字母码申请记录
     * 
     * @param id 字母码申请记录主键
     * @return 结果
     */
    public int deleteBarCodeApplyById(Long id);

    /**
     * 批量删除字母码申请记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBarCodeApplyByIds(String[] ids);

    /**
     * 根据条件查询一条申请记录
     * @param barCodeApply
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/19
     */
    BarCodeApply getOneByWhere(BarCodeApply barCodeApply);


    /**
     * 更改申请状态
     * @param id
     * @param newStatus
     * @param oldStatus
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/19
     */
    int changeStatus(@Param("id") Long id, @Param("newStatus") Integer newStatus, @Param("oldStatus") Integer oldStatus);

    /**
     * 更新已生成数量
     * @param existNum
     * @param endNum
     * @return
     */
    int updateExitsAndEndNum(@Param("applyId") long applyId,@Param("existNum") Integer existNum);

    /**
     * 根据申请id结束号
     * @param applyId
     * @return
     */
    int selectEndNumById(long applyId);


}
