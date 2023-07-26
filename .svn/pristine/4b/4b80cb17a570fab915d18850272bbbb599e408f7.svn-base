package com.linkwin.basedata.domain;

import java.util.List;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;

/**
 * 部门对象 sys_dept
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
@Data
public class ManageOrganizations
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long code;
//
//    /** 父部门id */
//    @Excel(name = "父部门id")
//    private Long parentId;
//
//    /** 祖级列表 */
//    @Excel(name = "祖级列表")
//    private String ancestors;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String name;

//    /** 显示顺序 */
//    @Excel(name = "显示顺序")
//    private Integer orderNum;
//
//    /** 负责人 */
//    @Excel(name = "负责人")
//    private String leader;
//
//    /** 联系电话 */
//    @Excel(name = "联系电话")
//    private String phone;
//
//    /** 邮箱 */
//    @Excel(name = "邮箱")
//    private String email;
//
//    /** 部门状态（0正常 1停用） */
//    @Excel(name = "部门状态", readConverterExp = "0=正常,1=停用")
//    private String status;
//
//    /** 删除标志（0代表存在 2代表删除） */
//    private String delFlag;
//
//    /** 代理区域 */
//    @Excel(name = "代理区域")
//    private String agentArea;
//
//    /** 注册地址 */
//    @Excel(name = "注册地址")
//    private String registeredAddress;
//
//    /** 收货地址 */
//    @Excel(name = "收货地址")
//    private String receivingAddress;

    /** $table.subTable.functionName信息 */
    private List<WarehouseVO> WarehouseList;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("code",getCode())
                .append("name",getName())
             .append("WarehouseNoList", getWarehouseList())
            .toString();
    }
}
