package com.linkwin.order.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 单据条码明细对象 bill_order_barcode
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
@Data
public class BillOrderBarcode extends BaseEntity
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

    /** 产品SAP编码 */
    @Excel(name = "产品SAP编码")
    private String sapProductCode;

    /** 批次 */
    @Excel(name = "批次")
    private String productBatch;

    /** 码 */
    @Excel(name = "码")
    private String barCode;

    /** 起始物流码 */
    @Excel(name = "起始物流码")
    private Integer startLogisticsCode;

    /** 结束物流码 */
    @Excel(name = "结束物流码")
    private Integer endLogisticsCode;

    /** 类型（1  箱码  2 托码） */
    @Excel(name = "类型", readConverterExp = "1=,箱=码,2=,托=码")
    private Integer barCodeType;

    /** 箱数 */
    @Excel(name = "箱数")
    private BigDecimal caseQuantity;

    /** 集装箱号 */
    @Excel(name = "集装箱号")
    private String containerNo;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String orderNo;

    /** 单据明细id */
    @Excel(name = "单据明细id")
    private Long detailId;

    /** 是否复核 （0=未复核 1=已复核） */
    @Excel(name = "是否复核 ", readConverterExp = "0==未复核,2==已复核")
    private Integer isChecked;

    /** 复核人id */
    @Excel(name = "复核人id")
    private Long reviewerId;

    /** 复核人名称 */
    @Excel(name = "复核人名称")
    private String reviewer;

    /** 复核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "复核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewerTime;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pdCode", getPdCode())
            .append("pdName", getPdName())
            .append("sapProductCode", getSapProductCode())
            .append("productBatch", getProductBatch())
            .append("barCode", getBarCode())
            .append("startLogisticsCode", getStartLogisticsCode())
            .append("endLogisticsCode", getEndLogisticsCode())
            .append("barCodeType", getBarCodeType())
            .append("caseQuantity", getCaseQuantity())
            .append("containerNo", getContainerNo())
            .append("orderNo", getOrderNo())
            .append("detailId", getDetailId())
            .append("isChecked", getIsChecked())
            .append("reviewerId", getReviewerId())
            .append("reviewer", getReviewer())
            .append("reviewerTime", getReviewerTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
