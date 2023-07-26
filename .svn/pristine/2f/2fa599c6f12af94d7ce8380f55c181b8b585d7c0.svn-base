package com.linkwin.basedata.mapper;

import java.util.List;

import com.linkwin.basedata.domain.AllProduct;
import com.linkwin.basedata.domain.Product;
import org.apache.ibatis.annotations.Param;

/**
 * 产品信息Mapper接口
 * 
 * @author dingyuming
 * @date 2022-05-10
 */
public interface ProductMapper 
{
    /**
     * 查询产品信息
     * 
     * @param id 产品信息主键
     * @return 产品信息
     */
    public Product selectProductById(Long id);

    /**
     * 查询产品信息列表
     * 
     * @param product 产品信息
     * @return 产品信息集合
     */
    public List<Product> selectProductList(Product product);
    public List<Product> selectCashingProductList(Product product);



        public List<AllProduct> selectAllProductList(Product product);
    /**
     * 新增产品信息
     * 
     * @param product 产品信息
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改产品信息
     * 
     * @param product 产品信息
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除产品信息
     * 
     * @param id 产品信息主键
     * @return 结果
     */
    public int deleteProductById(Long id);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByIds(String[] ids);

    /**
     * 根据产品编码查询产品
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/8
     */
    Product selectByPdCode(String code);


    Product selectProductDataByCode(String code);

    public  List<Product> selectProductDataByOrganCode(Product productData);
    public  List<Product> selectUmProductDataByOrganCode(@Param("code") Long code,@Param("organcode") String organcode ,@Param("name") String name);

    public List<Product> selectProductListonlyName(Product productData);

}
