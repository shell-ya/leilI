package com.linkwin.basedata.mapper;

import java.util.List;
import com.linkwin.basedata.domain.ManageOrganizations;
import com.linkwin.basedata.domain.Warehouse;
import org.apache.ibatis.annotations.Param;

/**
 * 部门Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-06
 */
public interface DeptMapper
{

    public List<ManageOrganizations> selectManageOrganizationList(ManageOrganizations sysDept);

    /**
     * 查询Warehouse列表
     *
     * @param Warehouse Warehouse
     * @return Warehouse集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse Warehouse);
    /**
     * 根据仓库编号查询
     * @param code
     * @return
     */
    Warehouse selectByCode(String code);

    public Warehouse selectByOrganCode(@Param("organCode") String organCode);

    int insertByPdname(@Param("code")Long code,@Param("id") String id);

    Integer selectdeptidDesc( );


}
