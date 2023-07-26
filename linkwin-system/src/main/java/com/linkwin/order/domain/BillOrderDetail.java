package com.linkwin.order.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 单据明细对象 bill_order_detail
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Data
public class BillOrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String pdName;

    /** 重量 */
    private BigDecimal weight;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String orderNo;

    /** 批号 */
    @Excel(name = "批号")
    private String pdBatch;

    /** 复核人id */
    private Long reviewerId;

    /** 复核人名称 */
    @Excel(name = "复核人名称")
    private String reviewer;

    /** 复核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "复核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewerTime;

    /** 辅助属性 */
    @Excel(name = "辅助属性")
    private String auxiliaryProperties;

    /** 规格编号 */
    @Excel(name = "规格编号")
    private String spec;

    /** 发货仓库 */
    @Excel(name = "发货仓库")
    private String sendWarehouse;

    /** 单据明细信息 */
    private List<BillOrderBarcode> BillOrderBarcodeList;

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
    public void setPdName(String pdName) 
    {
        this.pdName = pdName;
    }

    public String getPdName() 
    {
        return pdName;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setPdBatch(String pdBatch) 
    {
        this.pdBatch = pdBatch;
    }

    public String getPdBatch() 
    {
        return pdBatch;
    }
    public void setReviewerId(Long reviewerId) 
    {
        this.reviewerId = reviewerId;
    }

    public Long getReviewerId() 
    {
        return reviewerId;
    }
    public void setReviewer(String reviewer) 
    {
        this.reviewer = reviewer;
    }

    public String getReviewer() 
    {
        return reviewer;
    }
    public void setReviewerTime(Date reviewerTime) 
    {
        this.reviewerTime = reviewerTime;
    }

    public Date getReviewerTime() 
    {
        return reviewerTime;
    }
    public void setAuxiliaryProperties(String auxiliaryProperties) 
    {
        this.auxiliaryProperties = auxiliaryProperties;
    }

    public String getAuxiliaryProperties() 
    {
        return auxiliaryProperties;
    }
    public void setSpec(String spec) 
    {
        this.spec = spec;
    }

    public String getSpec() 
    {
        return spec;
    }
    public void setSendWarehouse(String sendWarehouse) 
    {
        this.sendWarehouse = sendWarehouse;
    }

    public String getSendWarehouse() 
    {
        return sendWarehouse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pdCode", getPdCode())
            .append("pdName", getPdName())
            .append("weight", getWeight())
            .append("quantity", getQuantity())
            .append("unit", getUnit())
            .append("orderNo", getOrderNo())
            .append("pdBatch", getPdBatch())
            .append("createTime", getCreateTime())
            .append("reviewerId", getReviewerId())
            .append("reviewer", getReviewer())
            .append("reviewerTime", getReviewerTime())
            .append("auxiliaryProperties", getAuxiliaryProperties())
            .append("spec", getSpec())
            .append("sendWarehouse", getSendWarehouse())
            .append("remark", getRemark())
            .toString();
    }
}
