package com.linkwin.Integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * IntegralRecord对象 integral_record
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
public class IntegralRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 手机号码 */
    private String phone;

    /** 积分变动数量 */
    @Excel(name = "积分变动数量")
    private Integer changeNumber;

    /** 当前积分 */
    @Excel(name = "当前积分")
    private Integer curreryIntegral;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String productCode;

    /** 产品数量 */
    @Excel(name = "产品数量")
    private Integer productNumber;

    /** 变动原因 */
    @Excel(name = "变动原因")
    private String changeReason;

    /** 变动标志 */
    @Excel(name = "变动标志")
    private String changeFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setChangeNumber(Integer changeNumber)
    {
        this.changeNumber = changeNumber;
    }

    public Integer getChangeNumber()
    {
        return changeNumber;
    }
    public void setCurreryIntegral(Integer curreryIntegral)
    {
        this.curreryIntegral = curreryIntegral;
    }

    public Integer getCurreryIntegral()
    {
        return curreryIntegral;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setProductNumber(Integer productNumber)
    {
        this.productNumber = productNumber;
    }

    public Integer getProductNumber()
    {
        return productNumber;
    }
    public void setChangeReason(String changeReason) 
    {
        this.changeReason = changeReason;
    }

    public String getChangeReason() 
    {
        return changeReason;
    }
    public void setChangeFlag(String changeFlag) 
    {
        this.changeFlag = changeFlag;
    }

    public String getChangeFlag() 
    {
        return changeFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("changeNumber", getChangeNumber())
            .append("curreryIntegral", getCurreryIntegral())
            .append("createTime", getCreateTime())
            .append("productName", getProductName())
            .append("productCode", getProductCode())
            .append("productNumber", getProductNumber())
            .append("changeReason", getChangeReason())
            .append("changeFlag", getChangeFlag())
            .toString();
    }
}
