package com.linkwin.basedata.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.linkwin.common.annotation.Excel;
import com.linkwin.common.core.domain.BaseEntity;

/**
 * 库存对象 whstock
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
@Data
public class Whstock extends BaseEntity
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

    /** 库存数量/箱 */
    @Excel(name = "库存数量/箱")
    private BigDecimal inventoryquantity;

    /** 单位 */
    private String unit;

    /** 创建人 */
    private String creator;

    /** 修改人 */
    private String updator;

    /** 冻结标志:1正常，2冻结 */
    private Integer isdelete;

    /** 所在仓库 */
    @Excel(name = "所在仓库")
    private String WarehouseCode;

    /** 重量 */
    @Excel(name = "重量")
    private BigDecimal weight;

    /** 小包装数量 */
    private BigDecimal itemquantity;

    /** 订单号 */
    private String orderNo;

//    /** 东结数量 */
//    private BigDecimal freezeno;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String WarehouseName;

    /** 箱重 */
    private BigDecimal cartonweight;

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
    public void setWarehouseCode(String WarehouseCode)
    {
        this.WarehouseCode = WarehouseCode;
    }

    public String getWarehouseCode() 
    {
        return WarehouseCode;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setItemquantity(BigDecimal itemquantity) 
    {
        this.itemquantity = itemquantity;
    }

    public BigDecimal getItemquantity() 
    {
        return itemquantity;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
//    public void setFreezeno(BigDecimal freezeno)
//    {
//        this.freezeno = freezeno;
//    }
//
//    public BigDecimal getFreezeno()
//    {
//        return freezeno;
//    }
    public void setWarehouseName(String WarehouseName)
    {
        this.WarehouseName = WarehouseName;
    }

    public String getWarehouseName() 
    {
        return WarehouseName;
    }
    public void setCartonweight(BigDecimal cartonweight)
    {
        this.cartonweight = cartonweight;
    }

    public BigDecimal getCartonweight()
    {
        return cartonweight;
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
            .append("WarehouseCode", getWarehouseCode())
            .append("weight", getWeight())
            .append("itemquantity", getItemquantity())
            .append("orderNo", getOrderNo())
//            .append("freezeno", getFreezeno())
            .append("WarehouseName", getWarehouseName())
            .append("cartonweight", getCartonweight())
            .toString();
    }
}
