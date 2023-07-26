package com.linkwin.basedata.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.domain.Whstock;
import org.apache.ibatis.annotations.Param;

/**
 * 库存Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-09
 */
public interface WhstockMapper 
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
     * 删除库存
     * 
     * @param id 库存主键
     * @return 结果
     */
    public int deleteWhstockById(Long id);

    /**
     * 批量删除库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWhstockByIds(String[] ids);


    public  List<Whstock> selectList (Whstock whstock);


    /**
     * 根据仓库编码查询该仓库下的总库存
     * @param warehouseCode
     * @return
     * @Author qipeng.zheng
     * @Date 2022/8/31
     */
    BigDecimal selectWhstockNumByWarehouse(String warehouseCode);

    /**
     * 根据仓库查询该仓库的入库数量
     * @param warehouseCode
     * @return
     * @Author qipeng.zheng
     * @Date 2022/8/31
     */
    BigDecimal selectInCountByWarehouseCode(@Param("warehouseCode") String warehouseCode, @Param("orderType") Integer orderType);


    /**
     * 根据仓库id查询库存数据
     *
     * @param whstock
     * @param deptIds
     * @return
     */
    List<Whstock> selectWhstockListByWarehouse(@Param("whstock")Whstock whstock,@Param("deptIds")List<Long> deptIds);
}
