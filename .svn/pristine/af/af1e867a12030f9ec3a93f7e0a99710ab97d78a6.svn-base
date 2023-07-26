package com.linkwin.basedata.domain;

import com.linkwin.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class AllProduct {
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
    private String spec;

    /** 剂型 */
    @Excel(name = "剂型")
    private String unit;
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("name", getName())
                .append("spec", getSpec())

                .append("unit", getUnit())

                .toString();}

}
