package com.linkwin.order.service;

import java.util.List;
import com.linkwin.order.domain.BillOrderBarcode;
import org.springframework.web.multipart.MultipartFile;

/**
 * 单据条码明细Service接口
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
public interface IBillOrderBarcodeService 
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

    /**
     * 批量删除单据条码明细
     * 
     * @param ids 需要删除的单据条码明细主键集合
     * @return 结果
     */
    public int deleteBillOrderBarcodeByIds(String ids);

    /**
     * 删除单据条码明细信息
     * 
     * @param id 单据条码明细主键
     * @return 结果
     */
    public int deleteBillOrderBarcodeById(Long id);

    /**
     * 解决入库时每个母码数据少计算一个小件，需要补上该部分的库存
     */
    public void solutionBarcode();



}
