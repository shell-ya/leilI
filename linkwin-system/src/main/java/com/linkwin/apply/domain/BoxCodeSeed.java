package com.linkwin.apply.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 box_code_seed
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
public class BoxCodeSeed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 年 */
    @Excel(name = "年")
    private Integer year;

    /** 种子 */
    @Excel(name = "种子")
    private String seed;

    /** 种子长度 */
    @Excel(name = "种子长度")
    private Integer seedLength;

    /** 是否使用完 */
    @Excel(name = "是否使用完")
    private Integer isEnd;

    /** 起始数字 */
    @Excel(name = "起始数字")
    private Long startNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getYear()
    {
        return year;
    }
    public void setSeed(String seed) 
    {
        this.seed = seed;
    }

    public String getSeed() 
    {
        return seed;
    }
    public void setSeedLength(Integer seedLength) 
    {
        this.seedLength = seedLength;
    }

    public Integer getSeedLength() 
    {
        return seedLength;
    }
    public void setIsEnd(Integer isEnd)
    {
        this.isEnd = isEnd;
    }

    public Integer getIsEnd()
    {
        return isEnd;
    }
    public void setStartNum(Long startNum) 
    {
        this.startNum = startNum;
    }

    public Long getStartNum() 
    {
        return startNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("year", getYear())
            .append("seed", getSeed())
            .append("seedLength", getSeedLength())
            .append("isEnd", getIsEnd())
            .append("startNum", getStartNum())
            .toString();
    }
}
