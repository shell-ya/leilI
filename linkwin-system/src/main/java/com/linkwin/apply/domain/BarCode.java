package com.linkwin.apply.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 箱码申请对象 bar_code
 * 
 * @author ruoyi
 * @date 20-05-19
 */
public class BarCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 母码申请记录id */
    @Excel(name = "母码申请记录id")
    private Long applyId;

    /** 母码 */
    @Excel(name = "母码")
    private String barCode;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 使用种子 */
    @Excel(name = "使用种子")
    private String seed;

    /** 起始流水号 */
    @Excel(name = "起始流水号")
    private Integer startNum;

    /** 结束流水号 */
    @Excel(name = "结束流水号")
    private Integer endNum;

    /** 母码 */
    @Excel(name = "母码")
    private List<String> randomCodeList;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 绑定产品时间 */
    @Excel(name = "绑定产品时间")
    private Date productionTime;

    /** 码前缀 */
    @Excel(name = "码前缀")
    private String prefixCode;


    private List<SubCode> subList;







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
    public void setBarCode(String barCode) 
    {
        this.barCode = barCode;
    }

    public String getBarCode() 
    {
        return barCode;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setSeed(String seed) 
    {
        this.seed = seed;
    }

    public String getSeed() 
    {
        return seed;
    }
    public void setStartNum(Integer startNum) 
    {
        this.startNum = startNum;
    }

    public Integer getStartNum() 
    {
        return startNum;
    }
    public void setEndNum(Integer endNum) 
    {
        this.endNum = endNum;
    }

    public Integer getEndNum() 
    {
        return endNum;
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

    public String getPrefixCode() {
        return prefixCode;
    }

    public void setPrefixCode(String prefixCode) {
        this.prefixCode = prefixCode;
    }

    public List<SubCode> getSubList() {
        return subList;
    }

    public void setSubList(List<SubCode> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyId", getApplyId())
            .append("barCode", getBarCode())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("seed", getSeed())
            .append("startNum", getStartNum())
            .append("endNum", getEndNum())
            .toString();
    }
}
