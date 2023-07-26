package com.linkwin.Integral.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * IntegralPerson对象 integral_person
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
@Data
public class IntegralPerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话号码 */
    private String phone;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String address;

    /** 当前积分 */
    @Excel(name = "当前积分")
    private Integer integral;


    private String openId;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("integral", getIntegral())
            .toString();
    }
}
