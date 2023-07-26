package com.linkwin.system.domain;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 软件版本控制对象 software_control
 * 
 * @author ruoyi
 * @date 2022-09-19
 */
public class SoftwareControl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 大版本号 */
    @Excel(name = "大版本号")
    private Integer bigVersion;

    /** 小版本号 */
    @Excel(name = "小版本号")
    private Integer minVersion;

    /** 上传人id */
    @Excel(name = "上传人id")
    private Long upUserId;

    /** 上传人名称 */
    @Excel(name = "上传人名称")
    private String upUserName;

    /** 存储路径 */
    @Excel(name = "存储路径")
    private String filePath;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private Integer status;

    /** 软件类型 */
    @Excel(name = "软件类型")
    private String type;

    /** 文件大小 */
    private Long size;


    private String fileName;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBigVersion(Integer bigVersion) 
    {
        this.bigVersion = bigVersion;
    }

    public Integer getBigVersion() 
    {
        return bigVersion;
    }
    public void setMinVersion(Integer minVersion) 
    {
        this.minVersion = minVersion;
    }

    public Integer getMinVersion() 
    {
        return minVersion;
    }
    public void setUpUserId(Long upUserId) 
    {
        this.upUserId = upUserId;
    }

    public Long getUpUserId() 
    {
        return upUserId;
    }
    public void setUpUserName(String upUserName) 
    {
        this.upUserName = upUserName;
    }

    public String getUpUserName() 
    {
        return upUserName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bigVersion", getBigVersion())
            .append("minVersion", getMinVersion())
            .append("upUserId", getUpUserId())
            .append("upUserName", getUpUserName())
            .append("filePath", getFilePath())
            .append("isUse", getStatus())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
