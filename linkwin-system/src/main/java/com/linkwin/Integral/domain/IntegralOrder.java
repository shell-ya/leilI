package com.linkwin.Integral.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * IntegralOrder对象 integral_order
 * 
 * @author ruoyi
 * @date 2022-06-12
 */
@Data
public class IntegralOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String address;

    /** 数量 */
    @Excel(name = "数量")
    private Integer quantity;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String productCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 创建人 */
    private String creator;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    private  String receivemethod;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Integer getQuantity()
    {
        return quantity;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phoneNumber", getPhoneNumber())
            .append("address", getAddress())
            .append("quantity", getQuantity())
            .append("productCode", getProductCode())
            .append("productName", getProductName())
            .append("orderNo", getOrderNo())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
