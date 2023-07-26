package com.linkwin.basedata.mapper;

import java.util.List;
import com.linkwin.basedata.domain.SysProductOrgan;

/**
 * organproductMapper接口
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public interface SysProductOrganMapper 
{
    /**
     * 查询organproduct
     * 
     * @param productCode organproduct主键
     * @return organproduct
     */
    public SysProductOrgan selectSysProductOrganByProductCode(String productCode);
    public SysProductOrgan selectSysProductOrganByOrganCode(String OrganCode);


    /**
     * 查询organproduct列表
     * 
     * @param sysProductOrgan organproduct
     * @return organproduct集合
     */
    public List<SysProductOrgan> selectSysProductOrganList(SysProductOrgan sysProductOrgan);

    /**
     * 新增organproduct
     * 
     * @param sysProductOrgan organproduct
     * @return 结果
     */
    public int insertSysProductOrgan(SysProductOrgan sysProductOrgan);

    /**
     * 修改organproduct
     * 
     * @param sysProductOrgan organproduct
     * @return 结果
     */
    public int updateSysProductOrgan(SysProductOrgan sysProductOrgan);

    /**
     * 删除organproduct
     * 
     * @param productCode organproduct主键
     * @return 结果
     */
    public int deleteSysProductOrganByProductCode(String productCode);

    /**
     * 批量删除organproduct
     * 
     * @param productCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysProductOrganByProductCodes(String[] productCodes);
}
