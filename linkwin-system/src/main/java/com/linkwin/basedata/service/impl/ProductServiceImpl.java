package com.linkwin.basedata.service.impl;

import java.util.List;

import com.linkwin.basedata.domain.AllProduct;
import com.linkwin.basedata.domain.ManageOrganizations;
import com.linkwin.basedata.mapper.DeptMapper;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.order.mapper.BillOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.basedata.mapper.ProductMapper;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.common.core.text.Convert;

/**
 * 产品信息Service业务层处理
 * 
 * @author dingyuming
 * @date 2022-05-10
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private BillOrderMapper billOrderMapper;
    @Autowired
    private DeptMapper sysDeptMapper;
    /**
     * 查询产品信息
     * 
     * @param id 产品信息主键
     * @return 产品信息
     */
    @Override
    public Product selectProductById(Long id)
    {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询产品信息列表
     * 
     * @param product 产品信息
     * @return 产品信息
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    public List<Product> selectCashingProductList(Product product){
        return productMapper.selectCashingProductList(product);
    }

    /**
     * 新增产品信息
     * 
     * @param product 产品信息
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改产品信息
     * 
     * @param product 产品信息
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(String ids)
    {
        return productMapper.deleteProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id)
    {
        return productMapper.deleteProductById(id);
    }
    @Override
    public List<ManageOrganizations> selectManageOrganizationList(ManageOrganizations sysDept){
        return  sysDeptMapper.selectManageOrganizationList(sysDept);
    }
    @Override
    public List<AllProduct> selectAllProductList(Product product){
        return productMapper.selectAllProductList(product);
    }

    @Override
    public Product selectByPdCode(String code) {
        return productMapper.selectByPdCode(code);
    }


    @Override
    public List<Product > selectProductDataByOrganCode(Product productData) {

        return productMapper.selectProductDataByOrganCode(productData);
    }
    @Override
    public List<Product> selectUmProductDataByOrganCode(Long code,String organcode,String name) {
        return productMapper.selectUmProductDataByOrganCode(code,  organcode,name);
    }
    @Override

    public List<Product> selectProductListonlyName(Product productData){
        return productMapper.selectProductListonlyName(productData);

    }


}
