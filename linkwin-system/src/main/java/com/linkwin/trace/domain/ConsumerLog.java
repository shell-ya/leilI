package com.linkwin.trace.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 消费者信息日志对象 consumer_log
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public class ConsumerLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 扫码时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "扫码时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scanTime;

    /** 微信号 */
    @NotBlank(message = "微信号不能为空")
    @Excel(name = "微信号")
    private String openId;

    /** 电话 */
    @NotBlank(message = "电话不能为空")
    @Excel(name = "电话")
    private String phone;

    /** 位置 */
    @NotBlank(message = "位置不能为空")
    @Excel(name = "位置")
    private String address;

    /** 条码 */
    @NotBlank(message = "条码不能为空")
    @Excel(name = "条码")
    private String code;

    /** 码类型 1=子码 2=母码 3=箱码 */
    @Excel(name = "码类型 1=子码 2=母码 3=箱码")
    private String codeType;

    /** 销售地址 */
    @Excel(name = "销售地址")
    private String orderAddress;

    /** 防伪串货状态 1=正常 2=异常 */
    @Excel(name = "防伪串货状态 1=正常 2=异常")
    private String fwStatus;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String pdName;

    /** 机构编码 */
    @Excel(name = "机构编码")
    private Long organCode;

    /**  机构名称 */
    @Excel(name = "机构名称")
    private String organName;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setScanTime(Date scanTime) 
    {
        this.scanTime = scanTime;
    }

    public Date getScanTime() 
    {
        return scanTime;
    }
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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


    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getFwStatus() {
        return fwStatus;
    }

    public void setFwStatus(String fwStatus) {
        this.fwStatus = fwStatus;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public Long getOrganCode() {
        return organCode;
    }

    public void setOrganCode(Long organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("scanTime", getScanTime())
            .append("wechatNum", getOpenId())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("code", getCode())
            .append("codeType", getCodeType())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
