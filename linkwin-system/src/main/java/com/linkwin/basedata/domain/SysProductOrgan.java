package com.linkwin.basedata.domain;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * organproduct对象 sys_product_organ
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Data
public class SysProductOrgan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String productCode;

    /** 机构id */
    @Excel(name = "机构id")
    private String organCode;



    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("productCode", getProductCode())
            .append("organCode", getOrganCode())
            .toString();
    }
}
