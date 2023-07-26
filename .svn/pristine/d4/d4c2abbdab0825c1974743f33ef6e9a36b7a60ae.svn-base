package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BoxCode;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.mapping.ResultSetType;

import java.util.List;

/**
 * 箱码申请Mapper接口
 *
 * @author ruoyi
 * @date 20-05-13
 */
public interface BoxCodeMapper
{
    /**
     * 查询箱码申请
     *
     * @param id 箱码申请主键
     * @return 箱码申请
     */
    public BoxCode selectBoxCodeById(Long id);

    /**
     * 查询箱码申请列表
     *
     * @param boxCode 箱码申请
     * @return 箱码申请集合
     */
    public List<BoxCode> selectBoxCodeList(BoxCode boxCode);

    /**
     * 新增箱码申请
     *
     * @param boxCode 箱码申请
     * @return 结果
     */
    public int insertBoxCode(BoxCode boxCode);

    /**
     * 修改箱码申请
     *
     * @param boxCode 箱码申请
     * @return 结果
     */
    public int updateBoxCode(BoxCode boxCode);

    /**
     * 删除箱码申请
     *
     * @param id 箱码申请主键
     * @return 结果
     */
    public int deleteBoxCodeById(Long id);

    /**
     * 批量删除箱码申请
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBoxCodeByIds(String[] ids);

    /**
     * 查找申请记录码数量
     * @param applyId 记录id
     * @param tableName 表名
     * @return
     */
    int selectExitsNum(@Param("applyId") long applyId, @Param("tableName") String tableName);


    /**
     * mysql数据库 fetchSize这里只能设置成int最小值，否则流式查询不生效
     * @param applyId
     * @param table
     * @return
     */
    @Options(fetchSize = Integer.MIN_VALUE, resultSetType = ResultSetType.FORWARD_ONLY) //游标查询获取数据
    @Select("select id, apply_id as applyId, box_code as boxCode, create_time as createTime, modify_time as modifyTime from ${table} where apply_id = #{applyId}")
    Cursor<BoxCode> queryCodeForFile(@Param("applyId") long applyId, @Param("table") String table);


    /**
     * 根据表名和条码查询子码信息
     * @param tableName
     * @param code
     * @return
     */
    BoxCode selectByCode(@Param("tableName") String tableName, @Param("code") String code);

    /**
     * 根据表名和条码查询子码信息
     * @param tableName
     * @param codeArray
     * @return
     */
    List<BoxCode> selectByCodeArray(@Param("tableName") String tableName, @Param("codeArray") String[] codeArray);

    /**
     * 根据表名和条码查询子码信息
     * @param tableName
     * @param markCode
     * @return
     */
    BoxCode selectByMarkCode(@Param("tableName") String tableName, @Param("markCode") String markCode);



}
