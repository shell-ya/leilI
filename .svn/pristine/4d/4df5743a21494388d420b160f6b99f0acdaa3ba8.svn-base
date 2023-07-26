package com.linkwin.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 单据对象 bill_order
 *
 * @author ruoyi
 * @date 2021-10-25
 */
@Data
public class BillOrder extends BaseEntity{
        private static final long serialVersionUID = 1L;

        /** id */
        private Long id;

        /** 出库单号 */
        @Excel(name = "出库单号")
        private String orderNo;

        /** 单据类型 */
        private Integer orderType;

        /** 发货机构编码 */
        @Excel(name = "发货机构编码")
        private String sendOrganCode;

        /** 公司名称（发货） */
        @Excel(name = "公司名称", readConverterExp = "发=货")
        private String sendOrganName;

        /** 发货仓库编码 */
        @Excel(name = "发货仓库编码")
        private String sendWarehouseCode;

        /** 发货仓库名称 */
        @Excel(name = "发货仓库名称")
        private String sendWarehouseName;

        /** 收货机构编码 */
        @Excel(name = "收货机构编码")
        private String receiveOrganCode;

        /** 客户名称（收货） */
        @Excel(name = "客户名称", readConverterExp = "收=货")
        private String receiveOrganName;

        /** 收货仓库编码 */
        @Excel(name = "收货仓库编码")
        private String rceiveWarehouseCode;

        /** 收货仓库名称 */
        @Excel(name = "收货仓库名称")
        private String receiveWarehouseName;

        /** 收货仓库批次规则 */
        @Excel(name = "收货仓库批次规则")
        private String batchRule;

        /** 是否拣货 */
        private Integer isPicked;

        /** 是否复核 */
        private Integer isChecked;

        /** 制单人 */
        @Excel(name = "制单人")
        private String billCreator;

        /** 制单机构 */
        private String billCrearteOrganid;

        /** 制单时间 */
        @JsonFormat(pattern = "yyyy-MM-dd")
        @Excel(name = "制单时间", width = 30, dateFormat = "yyyy-MM-dd")
        private Date billCreatetime;

        /** 审核人id */
        @Excel(name = "审核人id")
        private Long reviewerId;

        /** 审核人名称 */
        @Excel(name = "审核人名称")
        private String reviewer;

        /** 审核时间 */
        @JsonFormat(pattern = "yyyy-MM-dd")
        @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
        private Date reviewerTime;

        /** 是否报废 0 否1 是 */
        private Long isDeleted;

        /** 质检人 */
        @Excel(name = "质检人")
        private String checker;

        /** 发货人 */
        @Excel(name = "发货人")
        private String sender;
        private  Long detailId;
        private String customer;
        private String customerName;
        //参数
        private String pdCode;
        private String sendwarehouseid;

        /** 打印日期 */
        private Date printTime;






        private  String   sendOrganid;

        /** 单据明细信息 */
        private List<BillOrderDetail> billOrderDetailList;

        public void setId(Long id)
        {
            this.id = id;
        }

        public Long getId()
        {
            return id;
        }
        public void setOrderNo(String orderNo)
        {
            this.orderNo = orderNo;
        }

        public String getOrderNo()
        {
            return orderNo;
        }
        public void setOrderType(Integer orderType)
        {
            this.orderType = orderType;
        }

        public Integer getOrderType()
        {
            return orderType;
        }
        public void setSendOrganCode(String sendOrganCode)
        {
            this.sendOrganCode = sendOrganCode;
        }

        public String getSendOrganCode()
        {
            return sendOrganCode;
        }
        public void setSendOrganName(String sendOrganName)
        {
            this.sendOrganName = sendOrganName;
        }

        public String getSendOrganName()
        {
            return sendOrganName;
        }
        public void setSendWarehouseCode(String sendWarehouseCode)
        {
            this.sendWarehouseCode = sendWarehouseCode;
        }

        public String getSendWarehouseCode()
        {
            return sendWarehouseCode;
        }
        public void setSendWarehouseName(String sendWarehouseName)
        {
            this.sendWarehouseName = sendWarehouseName;
        }

        public String getSendWarehouseName()
        {
            return sendWarehouseName;
        }
        public void setReceiveOrganCode(String receiveOrganCode)
        {
            this.receiveOrganCode = receiveOrganCode;
        }

        public String getReceiveOrganCode()
        {
            return receiveOrganCode;
        }
        public void setReceiveOrganName(String receiveOrganName)
        {
            this.receiveOrganName = receiveOrganName;
        }

        public String getReceiveOrganName()
        {
            return receiveOrganName;
        }
        public void setRceiveWarehouseCode(String rceiveWarehouseCode)
        {
            this.rceiveWarehouseCode = rceiveWarehouseCode;
        }

        public String getRceiveWarehouseCode()
        {
            return rceiveWarehouseCode;
        }
        public void setReceiveWarehouseName(String receiveWarehouseName)
        {
            this.receiveWarehouseName = receiveWarehouseName;
        }

        public String getReceiveWarehouseName()
        {
            return receiveWarehouseName;
        }
        public void setBatchRule(String batchRule)
        {
            this.batchRule = batchRule;
        }

        public String getBatchRule()
        {
            return batchRule;
        }
        public void setIsPicked(Integer isPicked)
        {
            this.isPicked = isPicked;
        }

        public Integer getIsPicked()
        {
            return isPicked;
        }
        public void setIsChecked(Integer isChecked)
        {
            this.isChecked = isChecked;
        }

        public Integer getIsChecked()
        {
            return isChecked;
        }
        public void setBillCreator(String billCreator)
        {
            this.billCreator = billCreator;
        }

        public String getBillCreator()
        {
            return billCreator;
        }
        public void setBillCrearteOrganid(String billCrearteOrganid)
        {
            this.billCrearteOrganid = billCrearteOrganid;
        }

        public String getBillCrearteOrganid()
        {
            return billCrearteOrganid;
        }
        public void setBillCreatetime(Date billCreatetime)
        {
            this.billCreatetime = billCreatetime;
        }

        public Date getBillCreatetime()
        {
            return billCreatetime;
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
        public void setIsDeleted(Long isDeleted)
        {
            this.isDeleted = isDeleted;
        }

        public Long getIsDeleted()
        {
            return isDeleted;
        }
        public void setChecker(String checker)
        {
            this.checker = checker;
        }

        public String getChecker()
        {
            return checker;
        }
        public void setSender(String sender)
        {
            this.sender = sender;
        }

        public String getSender()
        {
            return sender;
        }
        public void setPrintTime(Date printTime)
        {
            this.printTime = printTime;
        }

        public Date getPrintTime()
        {
            return printTime;
        }

        public List<BillOrderDetail> getBillOrderDetailList()
        {
            return billOrderDetailList;
        }

        public void setBillOrderDetailList(List<BillOrderDetail> billOrderDetailList)
        {
            this.billOrderDetailList = billOrderDetailList;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("orderNo", getOrderNo())
                    .append("orderType", getOrderType())
                    .append("sendOrganCode", getSendOrganCode())
                    .append("sendOrganName", getSendOrganName())
                    .append("sendWarehouseCode", getSendWarehouseCode())
                    .append("sendWarehouseName", getSendWarehouseName())
                    .append("receiveOrganCode", getReceiveOrganCode())
                    .append("receiveOrganName", getReceiveOrganName())
                    .append("rceiveWarehouseCode", getRceiveWarehouseCode())
                    .append("receiveWarehouseName", getReceiveWarehouseName())
                    .append("batchRule", getBatchRule())
                    .append("isPicked", getIsPicked())
                    .append("isChecked", getIsChecked())
                    .append("billCreator", getBillCreator())
                    .append("billCrearteOrganid", getBillCrearteOrganid())
                    .append("billCreatetime", getBillCreatetime())
                    .append("remark", getRemark())
                    .append("createTime", getCreateTime())
                    .append("reviewerId", getReviewerId())
                    .append("reviewer", getReviewer())
                    .append("reviewerTime", getReviewerTime())
                    .append("isDeleted", getIsDeleted())
                    .append("checker", getChecker())
                    .append("sender", getSender())
                    .append("printTime", getPrintTime())
                    .append("billOrderDetailList", getBillOrderDetailList())
                    .toString();
        }
}
