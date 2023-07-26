package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BarCode;
import com.linkwin.apply.domain.QrCodePre;
import com.linkwin.apply.domain.SubCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 二维码预生成Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface QrCodePreMapper 
{
    /**
     * 查询二维码预生成
     * 
     * @param id 二维码预生成主键
     * @return 二维码预生成
     */
    public QrCodePre selectQrCodePreById(Long id);

    /**
     * 查询二维码预生成列表
     * 
     * @param qrCodePre 二维码预生成
     * @return 二维码预生成集合
     */
    public List<QrCodePre> selectQrCodePreList(QrCodePre qrCodePre);

    /**
     * 新增二维码预生成
     * 
     * @param qrCodePre 二维码预生成
     * @return 结果
     */
    public int insertQrCodePre(QrCodePre qrCodePre);

    /**
     * 修改二维码预生成
     * 
     * @param qrCodePre 二维码预生成
     * @return 结果
     */
    public int updateQrCodePre(QrCodePre qrCodePre);

    /**
     * 删除二维码预生成
     * 
     * @param id 二维码预生成主键
     * @return 结果
     */
    public int deleteQrCodePreById(Long id);

    /**
     * 批量删除二维码预生成
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQrCodePreByIds(String[] ids);


    int getCount();


    /**
     *
     * @param barCodeList
     * @param
     * @return
     */
    void batchInsertQrCodePre(@Param("barCodeList") List<QrCodePre> barCodeList);

    /**
     * 标记码
     * @param applyId
     * @param year
     * @param count
     * @return
     */
    int updateQrCodePreApplyId(@Param("applyId") long applyId,@Param("year") int year, @Param("count") int count);

    /**
     * 迁移预生成表数据至正式码表
     * @param applyId
     * @param year
     * @param tableName
     * @return
     */
    int insertBarCode(@Param("applyId") long applyId, @Param("year") int year, @Param("tableName") String tableName,
                      @Param("startStr") String startStr,@Param("endStr") String endStr,@Param("startNum") Integer startNum,@Param("endNum") Integer endNum);


    /**
     * 根据申请编号删除预生成码
     * @param applyId
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/16
     */
    int deleteByApplyId(long applyId);

    /**
     *
     * @param applyId
     * @return
     */
    List<QrCodePre> selectByApplyId(Long applyId);


}
