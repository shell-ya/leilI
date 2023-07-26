package com.linkwin.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstEnum {

    QR_CODE("bar_code", "二维码"),
    SUB_CODE("sub_code", "子码"),
    BOX_CODE("box_code", "物流码"),
    PRODUCE("production_data","按照二维码年份分表"),

    //消费者查询窜货状态
    CONSUMER_EXCEPTION("2","窜货"),
    CONSUMER_OK("1","正常"),

    ACTIVITY_IS_ACTIVATION("1","已激活"),
    ACTIVITY_NOT_ACTIVATION("2","未激活"),
    ACTIVITY_IS_USE("3","已参加"),

    REDEEMED("1","已兑换"),
    UNCHANGED("2","未兑换"),

    BARCODE_UNCHECKED("0","未复核"),
    BARCODE_CHECKED("2","已复核");


    private String value;
    private String msg;
}

