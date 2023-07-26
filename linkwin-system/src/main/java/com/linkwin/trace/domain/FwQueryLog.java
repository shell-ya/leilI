package com.linkwin.trace.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 防伪查询记录对象 fw_query_log
 * 
 * @author ruoyi
 * @date 2022-06-02
 */
public class FwQueryLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 码 */
    @Excel(name = "码")
    private String code;

    /** 码类型 1=子码 2=母码 3=箱码 */
    @Excel(name = "码类型 1=子码 2=母码 3=箱码")
    private String codeType;

    /** 查询次数 */
    @Excel(name = "查询次数")
    private Integer queryNum;

    /** 批次 */
    @Excel(name = "批次")
    private String batchNo;

    /** 第一次查询时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第一次查询时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstQueryTime;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String pdName;

    /** 激活状态 1=激活 2=失效 */
    @Excel(name = "激活状态 1=激活 2=失效")
    private String activation;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPdCode(String pdCode) 
    {
        this.pdCode = pdCode;
    }

    public String getPdCode() 
    {
        return pdCode;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setCodeType(String codeType) 
    {
        this.codeType = codeType;
    }

    public String getCodeType() 
    {
        return codeType;
    }
    public void setQueryNum(Integer queryNum) 
    {
        this.queryNum = queryNum;
    }

    public Integer getQueryNum() 
    {
        return queryNum;
    }
    public void setBatchNo(String batchNo) 
    {
        this.batchNo = batchNo;
    }

    public String getBatchNo() 
    {
        return batchNo;
    }
    public void setFirstQueryTime(Date firstQueryTime) 
    {
        this.firstQueryTime = firstQueryTime;
    }

    public Date getFirstQueryTime() 
    {
        return firstQueryTime;
    }
    public void setPdName(String pdName) 
    {
        this.pdName = pdName;
    }

    public String getPdName() 
    {
        return pdName;
    }
    public void setActivation(String activation) 
    {
        this.activation = activation;
    }

    public String getActivation() 
    {
        return activation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pdCode", getPdCode())
            .append("code", getCode())
            .append("codeType", getCodeType())
            .append("queryNum", getQueryNum())
            .append("batchNo", getBatchNo())
            .append("firstQueryTime", getFirstQueryTime())
            .append("pdName", getPdName())
            .append("activation", getActivation())
            .toString();
    }
}
