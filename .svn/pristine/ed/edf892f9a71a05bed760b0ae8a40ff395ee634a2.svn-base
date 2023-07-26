package com.linkwin.apply.service;

import com.linkwin.apply.domain.BoxCodePre;

import java.util.List;

/**
 * 箱袋码预生成Service接口
 * 
 * @author ruoyi
 * @date 2022-05-12
 */
public interface IBoxCodePreService 
{
    /**
     * 查询箱袋码预生成
     * 
     * @param id 箱袋码预生成主键
     * @return 箱袋码预生成
     */
    public BoxCodePre selectBoxCodePreById(Long id);

    /**
     * 查询箱袋码预生成列表
     * 
     * @param boxCodePre 箱袋码预生成
     * @return 箱袋码预生成集合
     */
    public List<BoxCodePre> selectBoxCodePreList(BoxCodePre boxCodePre);

    /**
     * 新增箱袋码预生成
     * 
     * @param boxCodePre 箱袋码预生成
     * @return 结果
     */
    public int insertBoxCodePre(BoxCodePre boxCodePre);

    /**
     * 修改箱袋码预生成
     * 
     * @param boxCodePre 箱袋码预生成
     * @return 结果
     */
    public int updateBoxCodePre(BoxCodePre boxCodePre);

    /**
     * 批量删除箱袋码预生成
     * 
     * @param ids 需要删除的箱袋码预生成主键集合
     * @return 结果
     */
    public int deleteBoxCodePreByIds(String ids);

    /**
     * 删除箱袋码预生成信息
     * 
     * @param id 箱袋码预生成主键
     * @return 结果
     */
    public int deleteBoxCodePreById(Long id);

    /**
     * 根据种子生成码数据
     * @param seedLength 种子长度
     * @param randomCodeLength 随机码长度
     * @param step 步长
     * @return
     * @throws Exception
     */
    List<String> generateRandomCode(BoxCodePre boxCodePre,int seedLength,int randomCodeLength, int step,int year) throws Exception;


    /**
     * 根据申请编号标记预生成码
     * @param applyId
     * @param year
     * @param count
     * @Author qipeng.zheng
     * @Date 2022/5/16
     */
    void updateBoxCodePreApplyId(long applyId,int year,int count) throws RuntimeException;

    /**
     * 根据申请编号删除预生成码
     * @param applyId
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/16
     */
    int deleteByApplyId(long applyId);


    /**
     * 迁移标记的码数据至已生成的码表
     * @param applyId
     * @param year
     * @param tableName
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/16
     */
    int insertBoxCode(long applyId,int year,String tableName);





}
