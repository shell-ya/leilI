package com.linkwin.activity.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 兑换积分记录对象 exchange_integral
 * 
 * @author ruoyi
 * @date 2022-06-14
 */
public class ExchangeIntegral extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 营销码 */
    @Excel(name = "营销码")
    private String markCode;

    /** 是否兑换积分 0=未兑换 1=已兑换 */
    @Excel(name = "是否兑换积分 0=未兑换 1=已兑换")
    private String status;

    /** 微信号 */
    @Excel(name = "微信号")
    private String openId;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 兑换时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "兑换时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date exchangeTime;

    /** 兑换积分 */
    @Excel(name = "兑换积分")
    private Integer integral;

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
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setExchangeTime(Date exchangeTime) 
    {
        this.exchangeTime = exchangeTime;
    }

    public Date getExchangeTime() 
    {
        return exchangeTime;
    }
    public void setIntegral(Integer integral) 
    {
        this.integral = integral;
    }

    public Integer getIntegral() 
    {
        return integral;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("markCode", getMarkCode())
            .append("status", getStatus())
            .append("openId", getOpenId())
            .append("phone", getPhone())
            .append("exchangeTime", getExchangeTime())
            .append("integral", getIntegral())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
