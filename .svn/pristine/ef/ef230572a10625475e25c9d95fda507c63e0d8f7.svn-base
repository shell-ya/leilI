package com.linkwin.activity.domain;

import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 luckdraw_prize
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Data
public class LuckdrawPrize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 转盘角度 */
    @Excel(name = "转盘角度")
    private Long angle;

    /** 奖项级别 */
    @Excel(name = "奖项级别")
    private String level;

    /** 奖品名称 */
    @Excel(name = "奖品名称")
    private String name;

    /** 奖品数量 */
    @Excel(name = "奖品数量")
    private Integer num;

    /** 活动ID */
    @Excel(name = "活动ID")
    private Long activityid;

    /** 中奖概率数量 */
    @Excel(name = "中奖概率数量")
    private Integer ratenum;

    /** 奖品剩余数量 */
    @Excel(name = "奖品剩余数量")
    private Integer remainnum;


    /** 奖品剩余数量 */
    @Excel(name = "奖品剩余数量")
    private String activityName;

    /** 概率 */
    @Excel(name = "概率")
    private BigDecimal probability;

    /** 有无实物 */
    @Excel(name = "有无实物")
    private String isMaterial;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("angle", getAngle())
            .append("level", getLevel())
            .append("name", getName())
            .append("num", getNum())
            .append("activityid", getActivityid())
            .toString();
    }
}
