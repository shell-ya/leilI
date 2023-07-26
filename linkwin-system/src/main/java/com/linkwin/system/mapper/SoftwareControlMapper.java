package com.linkwin.system.mapper;

import com.linkwin.system.domain.SoftwareControl;

import java.util.List;

/**
 * 软件版本控制Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-19
 */
public interface SoftwareControlMapper 
{
    /**
     * 查询软件版本控制
     * 
     * @param id 软件版本控制主键
     * @return 软件版本控制
     */
    public SoftwareControl selectSoftwareControlById(Long id);

    /**
     * 查询软件版本控制列表
     * 
     * @param softwareControl 软件版本控制
     * @return 软件版本控制集合
     */
    public List<SoftwareControl> selectSoftwareControlList(SoftwareControl softwareControl);

    /**
     * 新增软件版本控制
     * 
     * @param softwareControl 软件版本控制
     * @return 结果
     */
    public int insertSoftwareControl(SoftwareControl softwareControl);

    /**
     * 修改软件版本控制
     * 
     * @param softwareControl 软件版本控制
     * @return 结果
     */
    public int updateSoftwareControl(SoftwareControl softwareControl);

    /**
     * 删除软件版本控制
     * 
     * @param id 软件版本控制主键
     * @return 结果
     */
    public int deleteSoftwareControlById(Long id);

    /**
     * 批量删除软件版本控制
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSoftwareControlByIds(String[] ids);

    /**
     * 查询最大版本号
     * @param type
     * @return
     * @Author qipeng.zheng
     * @Date 220920
     */
    SoftwareControl selectMaxVersion(String type);

}
