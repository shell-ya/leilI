package com.linkwin.activity.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 条码参加活动记录对象 code_activity_log
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
public class CodeActivityLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 码 */
    @NotBlank
    @Excel(name = "码")
    private String markCode;

    /** 参加活动类型 1=积分 2=活动红包 */
    @NotBlank
    @Excel(name = "参加活动类型 1=积分活动 2=大转盘 3=红包 4=其他")
    private String activityType;

    /** 参加活动时间 */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    @Excel(name = "参加活动时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date activityTime;

    /** 码类型 1=子码 2=单品码 */
    @Excel(name = "码类型 1=子码 2=单品码")
    private String codeType;

    /** 参加活动地址*/
    @Excel(name = "参加活动地址")
    private String address;





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
    public void setActivityType(String activityType) 
    {
        this.activityType = activityType;
    }

    public String getActivityType() 
    {
        return activityType;
    }
    public void setActivityTime(Date activityTime) 
    {
        this.activityTime = activityTime;
    }

    public Date getActivityTime() 
    {
        return activityTime;
    }
    public void setCodeType(String codeType)
    {
        this.codeType = codeType;
    }

    public String getCodeType()
    {
        return codeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getMarkCode())
            .append("activityType", getActivityType())
            .append("activityTime", getActivityTime())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("codeType", getCodeType())
            .toString();
    }
}
