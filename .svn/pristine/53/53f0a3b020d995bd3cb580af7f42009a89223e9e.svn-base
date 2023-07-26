package com.linkwin.basedata.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;

/**
 * ${subTable.functionName}对象 Warehouse
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
@Data
public class WarehouseVO {
    private static final long serialVersionUID = 1L;

//    /** $column.columnComment */
//    private Long id;

    /** 仓库编码 */
    @Excel(name = "仓库编码")
    private String wareHouseCode;

    /** 仓库名 */
    @Excel(name = "仓库名")
    private String name;
//
//    /** 仓库属性 */
//    @Excel(name = "仓库属性")
//    private String whProperty;
//
//    /** 负责人 */
//    @Excel(name = "负责人")
//    private String responsor;
//
//    /** 批次规则 */
//    @Excel(name = "批次规则")
//    private String WarehouseBatchRule;
//
//    /** 是否自动签收 */
//    @Excel(name = "是否自动签收")
//    private String isAutomateReceive;
//
//    /** 机构编码 */
//    @Excel(name = "机构编码")
//    private String organCode;
//
//    /** SAP仓库编码 */
//    @Excel(name = "SAP仓库编码")
//    private String sapWarehouseCode;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)

            .append("WarehouseCode", getWareHouseCode())
            .append("name", getName())

              .toString();
    }
}
