package com.linkwin.basedata.domain;

import com.linkwin.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Warehouse对象 Warehouse
 * 
 * @author ymding
 * @date 2021-10-26
 */
@Data
public class Warehouse
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 仓库编码 */
    @Excel(name = "仓库编码")
    private String wareHouseCode;

    /** 仓库名 */
    @Excel(name = "仓库名")
    private String name;

    /** 仓库属性 */
    @Excel(name = "仓库属性")
    private String whProperty;

    /** 负责人 */
    @Excel(name = "负责人")
    private String responsor;



    /** 批次规则 */
    @Excel(name = "批次规则")
    private String wareHouseBatchRule;

    /** 是否自动签收 */
    @Excel(name = "是否自动签收")
    private String isAutomateReceive;

    /** 机构ID */
    @Excel(name = "机构ID")
    private String organCode;





    private String remark;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("WarehouseCode", getWareHouseCode())
            .append("whName", getName())
            .append("whProperty", getWhProperty())
            .append("responsor", getResponsor())
            .append("WarehouseBatchRule", getWareHouseBatchRule())
            .append("isAutomateReceive", getIsAutomateReceive())
            .append("organCode", getOrganCode())
            .append("remark", getRemark())
             .toString();
    }
}
