package com.linkwin.activity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 活动管理对象 activity_manager
 * 
 * @author ruoyi
 * @date 2022-05-30
 */
@Data
public class ActivityManager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 活动标题 */
    @Excel(name = "活动标题")
    private String title;

    /** 活动url地址 */
    @Excel(name = "活动url地址")
    private String url;

    /** 活动状态 0=暂停 1=使用 */
    @Excel(name = "活动状态 0=暂停 1=使用")
    private Integer status;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createName;

    /** 活动图片地址 */
    @Excel(name = "活动图片地址")
    private String imgUrl;

    /** 活动介绍 */
    @Excel(name = "活动介绍")
    private String introduction;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String pdCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String pdName;

    /** 活动类型 */
    @Excel(name = "活动类型")
    private String activityType;

    /** 开始时间 */
    @Excel(name = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */

    @Excel(name = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private String truntablePath;

    @Excel(name = "奖项介绍")
    private String prizeExplain;


    private List<LuckdrawPrize> luckdrawPrizeList;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<LuckdrawPrize> getLuckdrawPrizeList() {
        return luckdrawPrizeList;
    }

    public void setLuckdrawPrizeList(List<LuckdrawPrize> luckdrawPrizeList) {
        this.luckdrawPrizeList = luckdrawPrizeList;
    }

    public String getPrizeExplain() {
        return prizeExplain;
    }

    public void setPrizeExplain(String prizeExplain) {
        this.prizeExplain = prizeExplain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("url", getUrl())
            .append("status", getStatus())
            .append("createId", getCreateId())
            .append("createName", getCreateName())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("imgUrl", getImgUrl())
            .append("introduction", getIntroduction())
            .toString();
    }
}
