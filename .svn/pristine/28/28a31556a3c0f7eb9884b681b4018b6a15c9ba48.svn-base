package com.linkwin.basedata.service.impl;

import java.util.List;

import com.linkwin.basedata.domain.ProductOrgan;
import com.linkwin.basedata.mapper.ProductOrganMapper;
import com.linkwin.basedata.service.IProductOrganService;
import com.linkwin.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 机构代理产品关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-15
 */
@Service
public class ProductOrganServiceImpl implements IProductOrganService
{
    @Autowired
    private ProductOrganMapper productOrganMapper;

    /**
     * 查询机构代理产品关联
     * 
     * @param id 机构代理产品关联主键
     * @return 机构代理产品关联
     */
    @Override
    public ProductOrgan selectProductOrganById(Long id)
    {
        return productOrganMapper.selectProductOrganById(id);
    }

    /**
     * 查询机构代理产品关联列表
     * 
     * @param productOrgan 机构代理产品关联
     * @return 机构代理产品关联
     */
    @Override
    public List<ProductOrgan> selectProductOrganList(ProductOrgan productOrgan)
    {
        return productOrganMapper.selectProductOrganList(productOrgan);
    }

    @Override
    public List<ProductOrgan> selectNotInOrganList(ProductOrgan productOrgan) {
        return productOrganMapper.selectNotInOrganList(productOrgan);
    }

    /**
     * 新增机构代理产品关联
     * 
     * @param productOrgan 机构代理产品关联
     * @return 结果
     */
    @Override
    public int insertProductOrgan(ProductOrgan productOrgan)
    {
        return productOrganMapper.insertProductOrgan(productOrgan);
    }

    /**
     * 修改机构代理产品关联
     * 
     * @param productOrgan 机构代理产品关联
     * @return 结果
     */
    @Override
    public int updateProductOrgan(ProductOrgan productOrgan)
    {
        return productOrganMapper.updateProductOrgan(productOrgan);
    }

    /**
     * 批量删除机构代理产品关联
     * 
     * @param ids 需要删除的机构代理产品关联主键
     * @return 结果
     */
    @Override
    public int deleteProductOrganByIds(String ids)
    {
        return productOrganMapper.deleteProductOrganByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机构代理产品关联信息
     * 
     * @param id 机构代理产品关联主键
     * @return 结果
     */
    @Override
    public int deleteProductOrganById(Long id)
    {
        return productOrganMapper.deleteProductOrganById(id);
    }

    @Transactional
    @Override
    public int addSaves(List<String> pdList, String organCode) {
        try {
            for (String pdCode:pdList){
                ProductOrgan productOrgan=new ProductOrgan();
                productOrgan.setOrganCode(organCode);
                productOrgan.setPdCode(pdCode);
                productOrganMapper.insertProductOrgan(productOrgan);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException();
        }
        return 1;
    }
}
