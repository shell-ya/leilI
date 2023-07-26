package com.linkwin.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActivityEnum {
    INTEGRAL("1", "积分活动"),
    TURNTABLE("2", "大转盘活动"),
    RED_ENVELOPES("3", "红包活动"),
    OTHER("4", "其他活动"),
    ;
    private String value;
    private String msg;

    public static String getMsgByValue(String value) {
        for (ActivityEnum e : ActivityEnum.values()) {
            if (e.getValue().equals(value)) {
                return e.getMsg();
            }
        }
        return "";
    }


}
