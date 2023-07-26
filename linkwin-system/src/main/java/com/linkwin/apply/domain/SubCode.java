package com.linkwin.apply.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 箱码申请对象 sub_code
 * 
 * @author ruoyi
 * @date 20-05-19
 */
public class SubCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 母码申请记录id */
    @Excel(name = "母码申请记录id")
    private Long applyId;

    /** 子码 */
    @Excel(name = "子码")
    private String subCode;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 所属母码 */
    @Excel(name = "所属母码")
    private String prefixCode;

    /** 使用种子 */
    @Excel(name = "使用种子")
    private String seed;

    /** 流水号 */
    @Excel(name = "流水号")
    private Integer serialNum;

    /** 子码 */
    @Excel(name = "子码")
    private List<String> randomCodeList;


    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 绑定产品时间 */
    @Excel(name = "绑定产品时间")
    private Date productionTime;

    /** 营销码 */
    @Excel(name = "营销码")
    private String markCode;


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
    public void setSubCode(String subCode) 
    {
        this.subCode = subCode;
    }

    public String getSubCode() 
    {
        return subCode;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setPrefixCode(String prefixCode)
    {
        this.prefixCode = prefixCode;
    }

    public String getPrefixCode()
    {
        return prefixCode;
    }
    public void setSeed(String seed) 
    {
        this.seed = seed;
    }

    public String getSeed() 
    {
        return seed;
    }
    public void setSerialNum(Integer serialNum) 
    {
        this.serialNum = serialNum;
    }

    public Integer getSerialNum() 
    {
        return serialNum;
    }

    public List<String> getRandomCodeList() {
        return randomCodeList;
    }

    public void setRandomCodeList(List<String> randomCodeList) {
        this.randomCodeList = randomCodeList;
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

    public String getMarkCode() {
        return markCode;
    }

    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyId", getApplyId())
            .append("subCode", getSubCode())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("parentCode", getPrefixCode())
            .append("seed", getSeed())
            .append("serialNum", getSerialNum())
            .toString();
    }
}
