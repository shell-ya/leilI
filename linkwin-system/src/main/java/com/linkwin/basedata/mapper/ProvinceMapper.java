package com.linkwin.basedata.mapper;

import com.linkwin.basedata.domain.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * provinceMapper接口
 * 
 * @author ruoyi
 * @date 2021-11-30
 */
public interface ProvinceMapper 
{
    /**
     * 查询province
     * 
     * @param code province主键
     * @return province
     */
    public Province selectProvinceByCode(String code);

    /**
     * 查询province列表
     * 
     * @param province province
     * @return province集合
     */
    public List<Province> selectProvinceList(Province province);

    /**
     * 新增province
     * 
     * @param province province
     * @return 结果
     */
    public int insertProvince(Province province);

    /**
     * 修改province
     * 
     * @param province province
     * @return 结果
     */
    public int updateProvince(Province province);

    /**
     * 删除province
     * 
     * @param code province主键
     * @return 结果
     */
    public int deleteProvinceByCode(String code);

    /**
     * 批量删除province
     * 
     * @param codes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProvinceByCodes(String[] codes);

    /**
     * 通过名字差统筹区号
     * @param
     * @return
     */
    public String selectProvinceListByname(@Param("name") String name, @Param("namelike") String namelike ,@Param("level") String level);
}
