package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.SubCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 箱码申请Mapper接口
 * 
 * @author ruoyi
 * @date 20-05-19
 */
public interface SubCodeMapper 
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
     * 删除箱码申请
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    public int deleteSubCodeById(Long id);

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubCodeByIds(String[] ids);

    /**
     * 批量新增子码
     * @param subCode
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/20
     */
    int batchInsertSubCode(SubCode subCode);


    /**
     * 根据申请id查询
     * @param subTableName
     * @param applyId
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/23
     */
    List<SubCode> selectSubCodeByApplyId(@Param("subTableName") String subTableName, @Param("applyId") long applyId,@Param("startNum") int startNum,@Param("endNum") int endNum,@Param("prefixCode") String prefixCode);

    /**
     * 根据表名和条码查询子码信息
     * @param tableName
     * @param code
     * @return
     */
    SubCode selectByCode(@Param("tableName") String tableName,@Param("code") String code);


    int queryTableName(@Param("tableName") String tableName);


    /**
     * 根据表名和营销码查询子码信息
     * @param tableName
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/17
     */
    SubCode selectByMarkCode(@Param("tableName") String tableName,@Param("markCode") String code);


    /**
     *
     * @param tableName
     * @param subCodeList
     */
    void batchInsertSubCodeList(@Param("tableName") String tableName,@Param("subCodeList") List<SubCode> subCodeList);



}
