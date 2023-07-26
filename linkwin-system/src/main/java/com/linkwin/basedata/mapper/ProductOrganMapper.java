package com.linkwin.basedata.mapper;

import com.linkwin.basedata.domain.ProductOrgan;

import java.util.List;

/**
 * 机构代理产品关联Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-15
 */
public interface ProductOrganMapper 
{
    /**
     * 查询机构代理产品关联
     * 
     * @param id 机构代理产品关联主键
     * @return 机构代理产品关联
     */
    public ProductOrgan selectProductOrganById(Long id);

    /**
     * 查询机构代理产品关联列表
     * 
     * @param productOrgan 机构代理产品关联
     * @return 机构代理产品关联集合
     */
    public List<ProductOrgan> selectProductOrganList(ProductOrgan productOrgan);

    /**
     * 查询没有关联关系的产品信息
     * @param productOrgan
     * @return
     */
    List<ProductOrgan> selectNotInOrganList(ProductOrgan productOrgan);


    /**
     * 新增机构代理产品关联
     * 
     * @param productOrgan 机构代理产品关联
     * @return 结果
     */
    public int insertProductOrgan(ProductOrgan productOrgan);

    /**
     * 修改机构代理产品关联
     * 
     * @param productOrgan 机构代理产品关联
     * @return 结果
     */
    public int updateProductOrgan(ProductOrgan productOrgan);

    /**
     * 删除机构代理产品关联
     * 
     * @param id 机构代理产品关联主键
     * @return 结果
     */
    public int deleteProductOrganById(Long id);

    /**
     * 批量删除机构代理产品关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductOrganByIds(String[] ids);
}
