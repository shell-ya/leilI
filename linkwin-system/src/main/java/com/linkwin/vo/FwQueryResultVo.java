package com.linkwin.vo;

import com.linkwin.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class FwQueryResultVo implements Serializable {

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String pdName;
    /** 信息 */
    @Excel(name = "信息")
    private String msg;
    /** 产品规格 */
    @Excel(name = "产品规格")
    private String specification;
    /** 查询次数*/
    @Excel(name = "查询次数")
    private Integer queryNum;
    /** 真伪*/
    @Excel(name = "真伪")
    private String authenticity;

    private String pdCode;

//    /** 激活状态 1 = 激活 2= 失效   (激活说明该码可以参加活动，失效说明该码已经参加过活动)*/
//    private String activation;

    private String activationMsg;

    private String code;

    /**  活动类型 */
    private String activityType;

    /**  活动标题*/
    private String activityTitle;

    /**  当前产品可以参加活动介绍*/
    private String activityIntroduction;

    private String activityMsg;

    private String proDateStr;

    private Date proDate;

    private String usemethod;

    /**  产品的图片内检地址 */
    private String productPath;

    private String companyEmail;

    private List<FwFlowVo> fwFlowVoList;




}
