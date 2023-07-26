package com.linkwin.apply.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 字母码申请记录对象 bar_code_apply
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class BarCodeApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 生成文件格式 1=txt格式 2=mdb格式 */
    @Excel(name = "生成文件格式 1=txt格式 2=mdb格式")
    private String fileFormat;

    /** 申请数量 */
    @Excel(name = "申请数量")
    private Integer applyNum;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 是否下载 0=未下载 1=已下载 */
    @Excel(name = "是否下载 0=未下载 1=已下载")
    private String isDownload;

    /** 下载次数 */
    @Excel(name = "下载次数")
    private Integer downloadNum;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 已生成数量 */
    @Excel(name = "已生成数量")
    private Integer existNum;

    /** 生成总数 */
    @Excel(name = "生成总数")
    private Integer totalNum;

    /** 补码数量 */
    @Excel(name = "补码数量")
    private Integer bumaNum;

    /** 处理失败 0=未处理 1=处理中 2=处理完成 3=处理失败 */
    @Excel(name = "处理失败 0=未处理 1=处理中 2=处理完成 3=处理失败")
    private Integer status;

    /** 补码率 */
    @Excel(name = "补码率")
    private Integer bumaRate;

    /** 码包密码 */
    @JSONField(serialize = false)
    @Excel(name = "码包密码")
    private String password;

    /** 最大下载次数 */
    @Excel(name = "最大下载次数")
    private Integer downloadMaxNum;

    /** 字母码比例 */
    @Excel(name = "字母码比例")
    private Integer proportion;

    /**  流水起始号 */
    private Integer startNum;

    /**   流水结束号 */
    private Integer endNum;

    /**   有无营销码 1=有涂层 2=无涂层 */
    private Integer applyType;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setFileFormat(String fileFormat) 
    {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() 
    {
        return fileFormat;
    }
    public void setApplyNum(Integer applyNum) 
    {
        this.applyNum = applyNum;
    }

    public Integer getApplyNum() 
    {
        return applyNum;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setIsDownload(String isDownload) 
    {
        this.isDownload = isDownload;
    }

    public String getIsDownload() 
    {
        return isDownload;
    }
    public void setDownloadNum(Integer downloadNum) 
    {
        this.downloadNum = downloadNum;
    }

    public Integer getDownloadNum() 
    {
        return downloadNum;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setExistNum(Integer existNum) 
    {
        this.existNum = existNum;
    }

    public Integer getExistNum() 
    {
        return existNum;
    }
    public void setTotalNum(Integer totalNum) 
    {
        this.totalNum = totalNum;
    }

    public Integer getTotalNum() 
    {
        return totalNum;
    }
    public void setBumaNum(Integer bumaNum) 
    {
        this.bumaNum = bumaNum;
    }

    public Integer getBumaNum() 
    {
        return bumaNum;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setBumaRate(Integer bumaRate) 
    {
        this.bumaRate = bumaRate;
    }

    public Integer getBumaRate() 
    {
        return bumaRate;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setDownloadMaxNum(Integer downloadMaxNum) 
    {
        this.downloadMaxNum = downloadMaxNum;
    }

    public Integer getDownloadMaxNum() 
    {
        return downloadMaxNum;
    }
    public void setProportion(Integer proportion) 
    {
        this.proportion = proportion;
    }

    public Integer getProportion() 
    {
        return proportion;
    }


    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("modifyTime", getModifyTime())
            .append("fileFormat", getFileFormat())
            .append("applyNum", getApplyNum())
            .append("fileName", getFileName())
            .append("isDownload", getIsDownload())
            .append("downloadNum", getDownloadNum())
            .append("filePath", getFilePath())
            .append("existNum", getExistNum())
            .append("totalNum", getTotalNum())
            .append("bumaNum", getBumaNum())
            .append("status", getStatus())
            .append("bumaRate", getBumaRate())
            .append("password", getPassword())
            .append("downloadMaxNum", getDownloadMaxNum())
            .append("proportion", getProportion())
            .toString();
    }
}
