package com.linkwin.basedata.service;

import java.math.BigDecimal;
import java.util.List;

import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.domain.Whstock;

/**
 * 库存Service接口
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
public interface IWhstockService 
{
    /**
     * 查询库存
     * 
     * @param id 库存主键
     * @return 库存
     */
    public Whstock selectWhstockById(Long id);

    /**
     * 查询库存列表
     * 
     * @param whstock 库存
     * @return 库存集合
     */
    public List<Whstock> selectWhstockList(Whstock whstock);


    /**
     * 查询库存列表
     *
     * @param whstock 库存
     * @param deptIds
     * @return 库存集合
     */
    public List<Whstock> selectWhstockListByWarehouse(Whstock whstock, List<Long> deptIds);

    /**
     * 新增库存
     * 
     * @param whstock 库存
     * @return 结果
     */
    public int insertWhstock(Whstock whstock);

    /**
     * 修改库存
     * 
     * @param whstock 库存
     * @return 结果
     */
    public int updateWhstock(Whstock whstock);

    /**
     * 批量删除库存
     * 
     * @param ids 需要删除的库存主键集合
     * @return 结果
     */
    public int deleteWhstockByIds(String ids);

    /**
     * 删除库存信息
     * 
     * @param id 库存主键
     * @return 结果
     */
    public int deleteWhstockById(Long id);

    public List<Whstock> selecttaskWhstockList(Whstock whstock);

    /**
     *  库存台账变更+库存新增
     * @param productId 产品的id
     * @param batch 产品批次
     * @param number 产品数量
     * @param thisWHid 当前仓库id
     * @param targetWHid 目的仓库id
     * @return
     */
    public int moreWhRecord(String productId, String batch, BigDecimal number, String thisWHid, String targetWHid, String reason) throws RuntimeException;
    /**
     *  库存台账变更+库存变更
     * @param productId 产品的id
     * @param batch 产品批次
     * @param number 产品数量
     * @param thisWHid 当前仓库id
     * @param targetWHid 目的仓库id
     * @return
     */
    public int whRecord(String productId,String batch,BigDecimal number,String thisWHid,String targetWHid,String reason ,String newBatch,Integer uploadType) throws RuntimeException;


    /**
     *  库存台账变更+库存新增
     * @param productCode 产品的id
     * @param batch 产品批次
     * @param number 产品数量
     * @param WarehouseCode 当前仓库id
     * @return
     */
    public int reduceWhRecord(String productCode, String batch, BigDecimal number, String WarehouseCode, String reason,Integer uploadType) throws RuntimeException;




    /**
     * 盘点库存  盘盈盘亏
     * @param whstock 库存
     * @param changNum 变更数量
     * @param changeFlag +| -
     * @param reason 备注
     * @return
     * @date 2023/3/31
     * @Author qipeng.zheng
     */
    int physicalInventory(Whstock whstock,BigDecimal changNum,String changeFlag,String reason);

}
