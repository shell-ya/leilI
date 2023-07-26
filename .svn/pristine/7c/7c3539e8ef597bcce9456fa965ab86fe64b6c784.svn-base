package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BoxCodePre;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 箱袋码预生成Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-12
 */
public interface BoxCodePreMapper 
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
     * 删除箱袋码预生成
     * 
     * @param id 箱袋码预生成主键
     * @return 结果
     */
    public int deleteBoxCodePreById(Long id);

    /**
     * 批量删除箱袋码预生成
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBoxCodePreByIds(String[] ids);

    /**
     * 获取预生成箱码总数
     * @Author qipeng.zheng
     * @return
     * @Date 2022/5/12
     */
    int getCount();

    /**
     * 批量新增预生成码数据至预生成表
     * @param boxCodePre
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/12
     */
    int batchInsert(BoxCodePre boxCodePre);

    /**
     * 标记码
     * @param applyId
     * @param year
     * @param count
     * @return
     */
    int updateBoxCodePreApplyId(@Param("applyId") long applyId,@Param("year") int year, @Param("count") int count);

    /**
     * 根据申请id删除预生成码数据
     * @param applyId
     * @return
     */
    int deleteByApplyId(long applyId);

    /**
     * 迁移预生成表数据至正式码表
     * @param applyId
     * @param year
     * @param tableName
     * @return
     */
    int insertBoxCode(@Param("applyId") long applyId, @Param("year") int year, @Param("tableName") String tableName);




}
