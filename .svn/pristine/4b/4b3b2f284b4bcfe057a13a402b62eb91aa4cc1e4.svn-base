package com.linkwin.basedata.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 产品信息对象 product
 * 
 * @author dingyuming
 * @date 2022-05-10
 */
@Data
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String code;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 通用名 */
    @Excel(name = "通用名")
    private String commonName;

    /** 登记证号 */
    @Excel(name = "登记证号")
    private String registrationNumber;

    /** 剂型 */
    @Excel(name = "剂型")
    private String dosageForm;

    /** 主要成分 */
    @Excel(name = "主要成分")
    private String mainComponents;

    /** 业绩系数 */
    @Excel(name = "业绩系数")
    private String performanceCoefficient;

    /** 常规/定制 */
    @Excel(name = "常规/定制",dictType = "routine_flag")

    private String routineFlag;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 修改人 */
//    @Excel(name = "修改人")
    private String modifier;

    /** 修改时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modificationtime;
    //logo
    private String logo;
    //使用方式
    @Excel(name = "使用方法")
    private String usemethod;
    //产品活动
    private String productActivities;
    //产品积分
    private Integer integral;
    //产品描述
    @Excel(name = "产品描述")
    private String proexplain;
    // 兑换所需积分
    private Integer needIntegral;
    @Excel(name = "箱重（Kg）")
    private BigDecimal cartonWeight;
    private String explainimg;
    @Excel(name = "执行标准")
    private String standard;
    private String integralflag;
    private String report;
    /**
     * 产品使用方式，产品活动，产品logo
     */

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }

    public String getSpecification()
    {
        return specification;
    }
    public void setCommonName(String commonName)
    {
        this.commonName = commonName;
    }

    public String getCommonName()
    {
        return commonName;
    }
    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }
    public void setDosageForm(String dosageForm)
    {
        this.dosageForm = dosageForm;
    }

    public String getDosageForm()
    {
        return dosageForm;
    }
    public void setMainComponents(String mainComponents)
    {
        this.mainComponents = mainComponents;
    }

    public String getMainComponents()
    {
        return mainComponents;
    }
    public void setPerformanceCoefficient(String performanceCoefficient)
    {
        this.performanceCoefficient = performanceCoefficient;
    }

    public String getPerformanceCoefficient()
    {
        return performanceCoefficient;
    }
    public void setRoutineFlag(String routineFlag)
    {
        this.routineFlag = routineFlag;
    }

    public String getRoutineFlag()
    {
        return routineFlag;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getCreator()
    {
        return creator;
    }
    public void setModifier(String modifier)
    {
        this.modifier = modifier;
    }

    public String getModifier()
    {
        return modifier;
    }
    public void setModificationtime(Date modificationtime)
    {
        this.modificationtime = modificationtime;
    }

    public Date getModificationtime()
    {
        return modificationtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("specification", getSpecification())
            .append("commonName", getCommonName())
            .append("registrationNumber", getRegistrationNumber())
            .append("dosageForm", getDosageForm())
            .append("mainComponents", getMainComponents())
            .append("performanceCoefficient", getPerformanceCoefficient())
            .append("routineFlag", getRoutineFlag())
            .append("remarks", getRemarks())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("modifier", getModifier())
            .append("modificationtime", getModificationtime())
            .toString();
    }
}
