package com.linkwin.system.service;

import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.system.domain.SoftwareControl;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 软件版本控制Service接口
 * 
 * @author ruoyi
 * @date 2022-09-19
 */
public interface ISoftwareControlService 
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
     * 批量删除软件版本控制
     * 
     * @param ids 需要删除的软件版本控制主键集合
     * @return 结果
     */
    public int deleteSoftwareControlByIds(String ids);

    /**
     * 删除软件版本控制信息
     * 
     * @param id 软件版本控制主键
     * @return 结果
     */
    public int deleteSoftwareControlById(Long id);


    /**
     * 上传软件
     * @param file
     * @param user
     * @return
     * @Author qipeng.zheng
     * @Date 220920
     */
    AjaxResult uploadSoftware(MultipartFile file, SysUser user);

    /**
     * 校验版本号
     * @param softwareControl
     * @return
     */
    boolean verifyVersion(SoftwareControl softwareControl);


}
