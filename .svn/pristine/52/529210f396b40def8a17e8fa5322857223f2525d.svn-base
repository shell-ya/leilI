package com.linkwin.apply.service;

import com.linkwin.apply.domain.BoxCodePre;
import com.linkwin.apply.domain.QrCodePre;
import com.linkwin.apply.domain.SubCode;

import java.util.List;

/**
 * 二维码预生成Service接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface IQrCodePreService 
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
     * 批量删除二维码预生成
     * 
     * @param ids 需要删除的二维码预生成主键集合
     * @return 结果
     */
    public int deleteQrCodePreByIds(String ids);

    /**
     * 删除二维码预生成信息
     * 
     * @param id 二维码预生成主键
     * @return 结果
     */
    public int deleteQrCodePreById(Long id);


    /**
     *
     * @param randomCodeLength
     * @param step
     * @param year
     * @return
     * @throws Exception
     */
    List<String> generateRandomCode(QrCodePre qrCodePre,int randomCodeLength, int step , int year) throws Exception;


    /**
     * 根据申请编号标记预生成码
     * @param applyId
     * @param year
     * @param count
     * @Author qipeng.zheng
     * @Date 2022/5/16
     */
    int updateQrCodePreApplyId(long applyId,int year,int count) throws RuntimeException;

    /**
     * 迁移标记的码数据至已生成的码表
     * @param applyId
     * @param year
     * @param tableName
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/16
     */
    int insertBarCode(long applyId,int year,String tableName,String startStr,String endStr,Integer startNum,Integer endNum);

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
