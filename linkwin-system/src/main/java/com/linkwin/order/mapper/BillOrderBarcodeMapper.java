package com.linkwin.order.mapper;

import java.util.List;

import com.linkwin.order.domain.BillOrderBarcode;
import org.apache.ibatis.annotations.Param;

/**
 * 单据条码明细Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
public interface BillOrderBarcodeMapper 
{
    /**
     * 查询单据条码明细
     * 
     * @param id 单据条码明细主键
     * @return 单据条码明细
     */
    public BillOrderBarcode selectBillOrderBarcodeById(Long id);

    /**
     * 查询单据条码明细列表
     * 
     * @param billOrderBarcode 单据条码明细
     * @return 单据条码明细集合
     */
    public List<BillOrderBarcode> selectBillOrderBarcodeList(BillOrderBarcode billOrderBarcode);

    /**
     * 查询单据条码明细列表
     *
     * @param codeArray 单据条码明细
     * @return 单据条码明细集合
     */
    public List<BillOrderBarcode> selectBillOrderBarcodeListByArray(@Param("isChecked")Integer isChecked ,@Param("codeArray")String[] codeArray);
    /**
     * 新增单据条码明细
     * 
     * @param billOrderBarcode 单据条码明细
     * @return 结果
     */
    public int insertBillOrderBarcode(BillOrderBarcode billOrderBarcode);

    /**
     * 修改单据条码明细
     * 
     * @param billOrderBarcode 单据条码明细
     * @return 结果
     */
    public int updateBillOrderBarcode(BillOrderBarcode billOrderBarcode);
    int updateBillOrderBarcodeByorderNo(BillOrderBarcode billOrderBarcode);


    /**
     * 删除单据条码明细
     * 
     * @param id 单据条码明细主键
     * @return 结果
     */
    public int deleteBillOrderBarcodeById(Long id);


    int deleteBillOrderBarcodeByCode(@Param("code") String code);
    /**
     * 批量删除单据条码明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBillOrderBarcodeByIds(String[] ids);

    public int insertbarcodeList(List<BillOrderBarcode> BillOrderBarcode);

    List<BillOrderBarcode> selectByOrderNoAndPdCode(@Param("orderNo") String orderNo, @Param("pdCode") String pdCode, @Param("detailId") Long detailId);




}
