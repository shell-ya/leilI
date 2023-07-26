package com.linkwin.basedata.domain;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 机构代理产品关联对象 product_organ
 * 
 * @author ruoyi
 * @date 2022-08-15
 */
public class ProductOrgan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 机构编码 */
    @Excel(name = "机构编码")
    private String organCode;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 产品规格 */
    @Excel(name = "产品规格")
    private String specification;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String pdName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrganCode(String organCode) 
    {
        this.organCode = organCode;
    }

    public String getOrganCode() 
    {
        return organCode;
    }
    public void setPdCode(String pdCode) 
    {
        this.pdCode = pdCode;
    }

    public String getPdCode() 
    {
        return pdCode;
    }
    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }
    public void setPdName(String pdName) 
    {
        this.pdName = pdName;
    }

    public String getPdName() 
    {
        return pdName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("organCode", getOrganCode())
            .append("pdCode", getPdCode())
            .append("specification", getSpecification())
            .append("pdName", getPdName())
            .toString();
    }
}
