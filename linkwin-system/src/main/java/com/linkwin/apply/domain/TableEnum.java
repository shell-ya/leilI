package com.linkwin.apply.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TableEnum {

    QR_CODE("bar_code", "二维码"),
    SUB_CODE("sub_code", "子码"),
    BOX_CODE("box_code", "物流码"),
    PRODUCE("production_data","按照二维码年份分表");

    private String value;
    private String msg;
}
