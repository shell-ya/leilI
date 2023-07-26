package com.linkwin.activity.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 营销码状态对象 integral_code_status
 * 
 * @author ruoyi
 * @date 2022-06-15
 */
public class IntegralCodeStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 营销码 */
    @Excel(name = "营销码")
    private String markCode;

    /** 状态 1=已激活 2=未激活 */
    @Excel(name = "状态 1=未激活 2=已激活 3=已参加")
    private String status;

    /** 营销码扫码时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "营销码扫码时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scanTime;

    /**  活动类型*/
    @Excel(name = "活动类型")
    private String activityType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMarkCode(String markCode)
    {
        this.markCode = markCode;
    }

    public String getMarkCode()
    {
        return markCode;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setScanTime(Date scanTime) 
    {
        this.scanTime = scanTime;
    }

    public Date getScanTime() 
    {
        return scanTime;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getMarkCode())
            .append("status", getStatus())
            .append("scanTime", getScanTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
