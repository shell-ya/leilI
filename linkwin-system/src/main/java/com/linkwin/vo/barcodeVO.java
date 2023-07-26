package com.linkwin.vo;

import com.linkwin.order.domain.BillOrderBarcode;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
@Data
public class barcodeVO {
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private String orderNo;
    private Long detailId;
//
private List<BillOrderBarcode> billOrderBarcodeList;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderNo", getOrderNo())
                .append("detailId", getDetailId())

                .append("billOrderBarcodeList", getBillOrderBarcodeList()).toString();
    }
}
