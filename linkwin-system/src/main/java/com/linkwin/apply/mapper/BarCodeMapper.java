package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BarCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 箱码申请Mapper接口
 * 
 * @author ruoyi
 * @date 20-05-19
 */
public interface BarCodeMapper 
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
     * 删除箱码申请
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    public int deleteBarCodeById(Long id);

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBarCodeByIds(String[] ids);

    /**
     * 查询已生成的母码数量
     * @param applyId
     * @param tableName
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/19
     */
    int selectExitsNum(@Param("applyId") long applyId, @Param("tableName") String tableName);

    /**
     * 批量新增母码
     * @param barCode
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/20
     */
    int batchInsertBarCode(BarCode barCode);

    /**
     * 根据申请id查询
     * @param barTableName
     * @param applyId
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/23
     */
    List<BarCode> selectBarCodeByApplyId(@Param("barTableName") String barTableName,@Param("applyId") long applyId);

    /**
     * 根据表名和码查询
     * @param tableName
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/16
     */
    BarCode selectByCode(@Param("tableName") String tableName, @Param("code") String code);

    /**
     * 根据表名和码Array查询
     * @param tableName
     * @param codeArray
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/16
     */
    List<BarCode> selectByCodeArray(@Param("tableName") String tableName, @Param("codeArray") String[] codeArray);

    /**
     *
     * @param tableName
     * @param pdCode
     * @param keyName
     * @param code
     * @return
     */
    int updateBarCode(@Param("tableName") String tableName, @Param("pdCode")String pdCode, @Param("keyName")String keyName, @Param("code") String code);

    /**
     *
     * @param tableName
     * @param pdCode
     * @param keyName
     * @param code
     * @return
     */
    int updateBarCodeBycodeArray(@Param("tableName") String tableName, @Param("pdCode")String pdCode,@Param("makeDate") String makeDate, @Param("keyName")String keyName, @Param("codeArray") String[] codeArray);

    /**
     * 更新子码表 产品code
     * @param tableName
     * @param pdCode
     * @param start_num
     * @param end_num
     * @return
     */
    int updateSubCodePdcode(@Param("tableName") String tableName, @Param("pdCode")String pdCode,@Param("makeDate") String makeDate,@Param("start_num") Integer start_num, @Param("end_num") Integer end_num,@Param("prefixCode") String prefixCode);
    /**

     * 根据种子和流水号查询所属母码信息
     * @param tableName
     * @param serialNum
     * @param seed
     * @return
     */
    BarCode selectBySerialNum(@Param("tableName") String tableName,@Param("serialNum") Integer serialNum,@Param("seed") String seed);

    /**
     * 根据申请记录查询码数据
     * @param applyId
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/30
     */
    List<BarCode> selectByApplyId(@Param("tableName") String tableName,@Param("subTableName") String subTableName,@Param("applyId") long applyId,@Param("page") Integer page,@Param("pageSize") Integer pageSize);


    /**
     * 根据码前缀查询母码
     * @param tableName
     * @param prefixCode
     * @return
     */
    BarCode selectByPrefixCode(@Param("tableName") String tableName,@Param("prefixCode") String prefixCode);


    /**
     *
     * @param tableName
     * @param barCodeList
     * @param
     * @return
     */
    void batchInsertBarCodeList(@Param("tableName") String tableName,@Param("barCodeList") List<BarCode> barCodeList);





}
