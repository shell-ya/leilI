package com.linkwin.apply.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 箱码申请对象 box_code_22
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
public class BoxCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 箱码申请记录id */
    @Excel(name = "箱码申请记录id")
    private Long applyId;

    /** 箱码 */
    @Excel(name = "箱码")
    private String boxCode;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 绑定产品时间 */
    @Excel(name = "绑定产品时间")
    private Date productionTime;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }
    public void setBoxCode(String boxCode) 
    {
        this.boxCode = boxCode;
    }

    public String getBoxCode() 
    {
        return boxCode;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyId", getApplyId())
            .append("boxCode", getBoxCode())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .toString();
    }
}
