package com.linkwin.common.core.domain.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.linkwin.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 部门表 sys_dept
 * 
 * @author ruoyi
 */
@Data
public class SysDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */

    private Long deptId;

    /** 父部门ID */
    @Excel(name = "上级机构编码")
    private Long parentId;

    /** 祖级列表 */

    private String ancestors;

    /** 经销商名称 */
    @Excel(name = "经销商名称")
    private String deptName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 部门状态:0正常,1停用 */
    @Excel(name = "部门状态：0正常,1停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 父经销商名称 */
    @Excel(name = "上级机构名称")
    private String parentName;

    /** 排除编号 */
    private Long excludeId;
    //代理区域
    @Excel(name = "代理区域")
    private  String agentArea;
    //注册地址
    @Excel(name = "注册地址")
    private  String registeredAddress;
    //    收货地址
    @Excel(name = "收货地址")
    private String receivingAddress;
    //备注
    @Excel(name = "备注")
    private String remark;
    @Excel(name = "省份")
    private String province;
    @Excel(name = "市区")
    private String city;
    private String country;
    @Excel(name = "机构级别")
    private String organLevel;

    private String provinceid;
    private String cityid;
    @Excel(name = "产品名称")
    private String pdName;
    @Excel(name = "产品编码")
    private String pdCode;



    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public String getAncestors()
    {
        return ancestors;
    }

    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    @NotBlank(message = "经销商名称不能为空")
    @Size(min = 0, max = 30, message = "经销商名称长度不能超过30个字符")
    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    @NotNull(message = "显示顺序不能为空")
    public Integer getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    @JsonIgnore
    public Long getExcludeId()
    {
        return excludeId;
    }

    public void setExcludeId(Long excludeId)
    {
        this.excludeId = excludeId;
    }

    public String getAgentArea() {
        return agentArea;
    }

    public void setAgentArea(String agentArea) {
        this.agentArea = agentArea;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("deptName", getDeptName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
