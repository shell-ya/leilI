package com.linkwin.log.service.impl;

import java.util.List;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.log.mapper.UploadLogMapper;
import com.linkwin.log.domain.UploadLog;
import com.linkwin.log.service.IUploadLogService;
import com.linkwin.common.core.text.Convert;

/**
 * 上传sap文件处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
@Service
public class UploadLogServiceImpl implements IUploadLogService 
{
    @Autowired
    private UploadLogMapper uploadLogMapper;

    /**
     * 查询上传sap文件处理
     * 
     * @param id 上传sap文件处理主键
     * @return 上传sap文件处理
     */
    @Override
    public UploadLog selectUploadLogById(Long id)
    {
        return uploadLogMapper.selectUploadLogById(id);
    }

    /**
     * 查询上传sap文件处理列表
     * 
     * @param uploadLog 上传sap文件处理
     * @return 上传sap文件处理
     */
    @Override
    public List<UploadLog> selectUploadLogList(UploadLog uploadLog)
    {
        return uploadLogMapper.selectUploadLogList(uploadLog);
    }

    /**
     * 新增上传sap文件处理
     * 
     * @param uploadLog 上传sap文件处理
     * @return 结果
     */
    @Override
    public int insertUploadLog(UploadLog uploadLog)
    {
        uploadLog.setCreateTime(DateUtils.getNowDate());
        return uploadLogMapper.insertUploadLog(uploadLog);
    }

    /**
     * 修改上传sap文件处理
     * 
     * @param uploadLog 上传sap文件处理
     * @return 结果
     */
    @Override
    public int updateUploadLog(UploadLog uploadLog)
    {
        return uploadLogMapper.updateUploadLog(uploadLog);
    }

    /**
     * 批量删除上传sap文件处理
     * 
     * @param ids 需要删除的上传sap文件处理主键
     * @return 结果
     */
    @Override
    public int deleteUploadLogByIds(String ids)
    {
        return uploadLogMapper.deleteUploadLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除上传sap文件处理信息
     * 
     * @param id 上传sap文件处理主键
     * @return 结果
     */
    @Override
    public int deleteUploadLogById(Long id)
    {
        return uploadLogMapper.deleteUploadLogById(id);
    }
}
