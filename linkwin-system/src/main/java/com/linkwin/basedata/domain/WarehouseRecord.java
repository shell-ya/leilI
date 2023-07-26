package com.linkwin.basedata.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * WarehouseRecoad对象 Warehouse_record
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
@Data
public class WarehouseRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 产品编号 */
    private String productid;

    /** 产品名 */
    @Excel(name = "产品名")
    private String productname;

    /** 产品规格 */
    private String spec;

    /** 批次 */
    @Excel(name = "批次")
    private String batch;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private BigDecimal inventoryquantity;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 创建人 */
    private String creator;

    /** 修改人 */
    private String updator;

    /** 删除标志 */
    private Integer isdelete;

    /** 出入库标志 */
    private String changeflag;

    /** 修改数量 */
    @Excel(name = "修改数量")
    private BigDecimal changenumber;

    /** 仓库cang */
    @Excel(name = "仓库编码")
    private String WarehouseId;

    /** 变更原因 */
    @Excel(name = "变更原因")
    private String reason;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String WarehouseName;
    private Date createtime;
    private Date updatetime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductid(String productid) 
    {
        this.productid = productid;
    }

    public String getProductid() 
    {
        return productid;
    }
    public void setProductname(String productname) 
    {
        this.productname = productname;
    }

    public String getProductname() 
    {
        return productname;
    }
    public void setSpec(String spec) 
    {
        this.spec = spec;
    }

    public String getSpec() 
    {
        return spec;
    }
    public void setBatch(String batch) 
    {
        this.batch = batch;
    }

    public String getBatch() 
    {
        return batch;
    }
    public void setInventoryquantity(BigDecimal inventoryquantity) 
    {
        this.inventoryquantity = inventoryquantity;
    }

    public BigDecimal getInventoryquantity() 
    {
        return inventoryquantity;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setUpdator(String updator) 
    {
        this.updator = updator;
    }

    public String getUpdator() 
    {
        return updator;
    }
    public void setIsdelete(Integer isdelete) 
    {
        this.isdelete = isdelete;
    }

    public Integer getIsdelete() 
    {
        return isdelete;
    }
    public void setChangeflag(String changeflag) 
    {
        this.changeflag = changeflag;
    }

    public String getChangeflag() 
    {
        return changeflag;
    }
    public void setChangenumber(BigDecimal changenumber) 
    {
        this.changenumber = changenumber;
    }

    public BigDecimal getChangenumber() 
    {
        return changenumber;
    }
    public void setWarehouseId(String WarehouseId)
    {
        this.WarehouseId = WarehouseId;
    }

    public String getWarehouseId() 
    {
        return WarehouseId;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setWarehouseName(String WarehouseName)
    {
        this.WarehouseName = WarehouseName;
    }

    public String getWarehouseName() 
    {
        return WarehouseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productid", getProductid())
            .append("productname", getProductname())
            .append("spec", getSpec())
            .append("batch", getBatch())
            .append("inventoryquantity", getInventoryquantity())
            .append("unit", getUnit())
            .append("creator", getCreator())
            .append("createtime", getCreatetime())
            .append("updator", getUpdator())
            .append("updatetime", getUpdatetime())
            .append("isdelete", getIsdelete())
            .append("remark", getRemark())
            .append("changeflag", getChangeflag())
            .append("changenumber", getChangenumber())
            .append("WarehouseId", getWarehouseId())
            .append("reason", getReason())
            .append("WarehouseName", getWarehouseName())
            .toString();
    }
}
