package com.linkwin.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExchangeIntegralResultVo implements Serializable {

    /** 本次兑换积分*/
    private Integer integral;

    /** 总积分*/
    private Integer integralTotal;

    /** 兑换状态 */
    private Boolean status;

    /** 消息*/
    private String msg;

    /**  手机 */
    private String phone;





}
