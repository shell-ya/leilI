package com.linkwin.log.mapper;

import java.util.List;
import com.linkwin.log.domain.UploadLog;

/**
 * 上传sap文件处理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
public interface UploadLogMapper 
{
    /**
     * 查询上传sap文件处理
     * 
     * @param id 上传sap文件处理主键
     * @return 上传sap文件处理
     */
    public UploadLog selectUploadLogById(Long id);

    /**
     * 查询上传sap文件处理列表
     * 
     * @param uploadLog 上传sap文件处理
     * @return 上传sap文件处理集合
     */
    public List<UploadLog> selectUploadLogList(UploadLog uploadLog);

    /**
     * 新增上传sap文件处理
     * 
     * @param uploadLog 上传sap文件处理
     * @return 结果
     */
    public int insertUploadLog(UploadLog uploadLog);

    /**
     * 修改上传sap文件处理
     * 
     * @param uploadLog 上传sap文件处理
     * @return 结果
     */
    public int updateUploadLog(UploadLog uploadLog);

    /**
     * 删除上传sap文件处理
     * 
     * @param id 上传sap文件处理主键
     * @return 结果
     */
    public int deleteUploadLogById(Long id);

    /**
     * 批量删除上传sap文件处理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUploadLogByIds(String[] ids);
}
