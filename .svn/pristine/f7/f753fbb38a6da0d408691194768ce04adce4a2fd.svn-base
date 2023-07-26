package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BoxCodeApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
public interface BoxCodeApplyMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BoxCodeApply selectBoxCodeApplyById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param boxCodeApply 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BoxCodeApply> selectBoxCodeApplyList(BoxCodeApply boxCodeApply);

    /**
     * 新增【请填写功能名称】
     * 
     * @param boxCodeApply 【请填写功能名称】
     * @return 结果
     */
    public int insertBoxCodeApply(BoxCodeApply boxCodeApply);

    /**
     * 修改【请填写功能名称】
     * 
     * @param boxCodeApply 【请填写功能名称】
     * @return 结果
     */
    public int updateBoxCodeApply(BoxCodeApply boxCodeApply);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBoxCodeApplyById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBoxCodeApplyByIds(String[] ids);

    /**
     * 查询一条记录
     * @param boxCodeApply
     * @return
     */
    BoxCodeApply getOneByWhere(BoxCodeApply boxCodeApply);

    /**
     * 更改申请状态
     * @param id
     * @param newStatus
     * @param oldStatus
     * @return
     */
    int changeStatus(@Param("id") Long id, @Param("newStatus") Integer newStatus, @Param("oldStatus") Integer oldStatus);

    /**
     * 更新生成数量
     * @param applyId
     * @param existNum
     * @return
     */
    int updateExitsAndEndNum(@Param("applyId") long applyId,@Param("existNum") Integer existNum);


}
