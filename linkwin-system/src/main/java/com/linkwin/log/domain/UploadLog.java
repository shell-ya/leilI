package com.linkwin.log.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 上传sap文件处理对象 upload_log
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
public class UploadLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 是否处理 */
    @Excel(name = "是否处理")
    private Integer isDeal;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 路径 */
    @Excel(name = "路径")
    private String filePath;

    /** 日志文件路径 */
    @Excel(name = "日志文件路径")
    private String logFilePath;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String billNo;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 日志文件名称 */
    @Excel(name = "日志文件名称")
    private String logFileName;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer handleStatus;

    /** 处理信息 */
    @Excel(name = "处理信息")
    private String handleMsg;

    /** 传输数据 */
    private String json;

    /** 返回日志 */
    private String response;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIsDeal(Integer isDeal) 
    {
        this.isDeal = isDeal;
    }

    public Integer getIsDeal() 
    {
        return isDeal;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setLogFilePath(String logFilePath) 
    {
        this.logFilePath = logFilePath;
    }

    public String getLogFilePath() 
    {
        return logFilePath;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setBillNo(String billNo) 
    {
        this.billNo = billNo;
    }

    public String getBillNo() 
    {
        return billNo;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setLogFileName(String logFileName) 
    {
        this.logFileName = logFileName;
    }

    public String getLogFileName() 
    {
        return logFileName;
    }
    public void setHandleStatus(Integer handleStatus) 
    {
        this.handleStatus = handleStatus;
    }

    public Integer getHandleStatus() 
    {
        return handleStatus;
    }
    public void setHandleMsg(String handleMsg) 
    {
        this.handleMsg = handleMsg;
    }

    public String getHandleMsg() 
    {
        return handleMsg;
    }
    public void setJson(String json) 
    {
        this.json = json;
    }

    public String getJson() 
    {
        return json;
    }
    public void setResponse(String response) 
    {
        this.response = response;
    }

    public String getResponse() 
    {
        return response;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isDeal", getIsDeal())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .append("logFilePath", getLogFilePath())
            .append("fileType", getFileType())
            .append("createTime", getCreateTime())
            .append("billNo", getBillNo())
            .append("version", getVersion())
            .append("logFileName", getLogFileName())
            .append("handleStatus", getHandleStatus())
            .append("handleMsg", getHandleMsg())
            .append("json", getJson())
            .append("response", getResponse())
            .toString();
    }
}
