package com.linkwin.apply.domain;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 二维码预生成对象 qr_code_pre
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public class QrCodePre extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 二维码 */
    @Excel(name = "二维码")
    private String code;

    /** 申请记录号 */
    @Excel(name = "申请记录号")
    private Long applyId;

    /** 种子 */
    @Excel(name = "种子")
    private String seed;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }
    public void setSeed(String seed) 
    {
        this.seed = seed;
    }

    public String getSeed() 
    {
        return seed;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("applyId", getApplyId())
            .append("createTime", getCreateTime())
            .append("seed", getSeed())
            .toString();
    }
}
