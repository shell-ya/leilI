package com.linkwin.activity.domain;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 wechat_phone_change
 * 
 * @author ruoyi
 * @date 2022-07-05
 */
public class WechatPhoneChange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 微信号 */
    @Excel(name = "微信号")
    private String openId;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openId", getOpenId())
            .append("phone", getPhone())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
