package com.linkwin.basedata.service;

import java.util.List;

import com.linkwin.basedata.domain.AllProduct;
import com.linkwin.basedata.domain.ManageOrganizations;
import com.linkwin.basedata.domain.Product;

/**
 * 产品信息Service接口
 * 
 * @author dingyuming
 * @date 2022-05-10
 */
public interface IProductService 
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
     * 批量删除产品信息
     * 
     * @param ids 需要删除的产品信息主键集合
     * @return 结果
     */
    public int deleteProductByIds(String ids);

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息主键
     * @return 结果
     */
    public int deleteProductById(Long id);
    public List<ManageOrganizations> selectManageOrganizationList(ManageOrganizations sysDept);
    public List<AllProduct> selectAllProductList(Product product);


    /**
     * 根据产品编码获取产品
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/8
     */
    Product selectByPdCode(String code);

    /**
     * cashing
     * @return
     */
    public List<Product> selectCashingProductList(Product product);

     public List<Product > selectProductDataByOrganCode(Product productData) ;

    public  List<Product> selectUmProductDataByOrganCode(Long code,String organcode,String name);

    public List<Product> selectProductListonlyName(Product productData);



}
