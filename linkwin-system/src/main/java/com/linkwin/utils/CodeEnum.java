package com.linkwin.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodeEnum {

    SUB_CODE("1", "子码"),
    BAR_CODE("2", "母码"),
    BOX_CODE("3", "箱码"),
    INTEGRAL_CODE("4", "营销码"),
    ;

    private String value;
    private String key;
}
