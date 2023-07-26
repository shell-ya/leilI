package com.linkwin.activity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.linkwin.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CodeActivityPrizeResultVo {


    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 营销码码 */
    @NotBlank
    @Excel(name = "码")
    private String code;

    /** 参加活动类型 1=积分 2=活动红包 */
    @NotBlank
    @Excel(name = "参加活动类型 1=积分 2=活动红包")
    private String activityType;

    /** 参加活动时间 */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    @Excel(name = "参加活动时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date activityTime;

    /** 码类型 1=子码 2=单品码 */
    @Excel(name = "码类型 1=子码 2=单品码")
    private String codeType;

    /**   是否具有权限查看中奖明细信息 */
    private boolean queryDetailPrizeAuthority;

    private ExchangePrize exchangePrize;

}
