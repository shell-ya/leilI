package com.linkwin.basedata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * province对象 province
 * 
 * @author ruoyi
 * @date 2021-11-30
 */
public class Province extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String code;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private Long modifier;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 上级区域 */
    @Excel(name = "上级区域")
    private String pcode;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String name;

    /** 英文名 */
    @Excel(name = "英文名")
    private String enName;

    /** 区域级别 1-大区 2-小区 3-省 */
    @Excel(name = "区域级别 1-大区 2-小区 3-省")
    private String regionLevel;

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setModifier(Long modifier) 
    {
        this.modifier = modifier;
    }

    public Long getModifier() 
    {
        return modifier;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setPcode(String pcode) 
    {
        this.pcode = pcode;
    }

    public String getPcode() 
    {
        return pcode;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setEnName(String enName) 
    {
        this.enName = enName;
    }

    public String getEnName() 
    {
        return enName;
    }
    public void setRegionLevel(String regionLevel) 
    {
        this.regionLevel = regionLevel;
    }

    public String getRegionLevel() 
    {
        return regionLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("code", getCode())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("modifier", getModifier())
            .append("modifyTime", getModifyTime())
            .append("pcode", getPcode())
            .append("name", getName())
            .append("enName", getEnName())
            .append("regionLevel", getRegionLevel())
            .append("remark", getRemark())
            .toString();
    }
}
