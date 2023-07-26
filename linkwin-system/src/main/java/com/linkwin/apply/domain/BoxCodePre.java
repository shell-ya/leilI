package com.linkwin.apply.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 箱袋码预生成对象 box_code_pre
 * 
 * @author ruoyi
 * @date 2022-05-12
 */
public class BoxCodePre extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 随机码部分 */
    @Excel(name = "随机码部分")
    private String randomCode;

    /** 使用种子 */
    @Excel(name = "使用种子")
    private String seed;

    /** 申请记录id */
    @Excel(name = "申请记录id")
    private Long applyId;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year;


    private List<String> codeList;

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
    public void setRandomCode(String randomCode) 
    {
        this.randomCode = randomCode;
    }

    public String getRandomCode() 
    {
        return randomCode;
    }
    public void setSeed(String seed) 
    {
        this.seed = seed;
    }

    public String getSeed() 
    {
        return seed;
    }
    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("randomCode", getRandomCode())
            .append("seed", getSeed())
            .append("applyId", getApplyId())
            .toString();
    }
}
