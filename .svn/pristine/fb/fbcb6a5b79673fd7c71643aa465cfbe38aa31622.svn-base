package com.linkwin.system.service.impl;

import java.util.List;

import com.linkwin.common.config.RuoYiConfig;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.common.utils.file.FileUploadUtils;
import com.linkwin.common.utils.file.FileUtils;
import com.linkwin.system.domain.SoftwareControl;
import com.linkwin.system.mapper.SoftwareControlMapper;
import com.linkwin.system.service.ISoftwareControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 软件版本控制Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-19
 */
@Service
public class SoftwareControlServiceImpl implements ISoftwareControlService
{
    @Autowired
    private SoftwareControlMapper softwareControlMapper;

    /**
     * 查询软件版本控制
     * 
     * @param id 软件版本控制主键
     * @return 软件版本控制
     */
    @Override
    public SoftwareControl selectSoftwareControlById(Long id)
    {
        return softwareControlMapper.selectSoftwareControlById(id);
    }

    /**
     * 查询软件版本控制列表
     * 
     * @param softwareControl 软件版本控制
     * @return 软件版本控制
     */
    @Override
    public List<SoftwareControl> selectSoftwareControlList(SoftwareControl softwareControl)
    {
        return softwareControlMapper.selectSoftwareControlList(softwareControl);
    }

    /**
     * 新增软件版本控制
     * 
     * @param softwareControl 软件版本控制
     * @return 结果
     */
    @Override
    public int insertSoftwareControl(SoftwareControl softwareControl)
    {


        softwareControl.setCreateTime(DateUtils.getNowDate());
        return softwareControlMapper.insertSoftwareControl(softwareControl);
    }

    /**
     * 修改软件版本控制
     * 
     * @param softwareControl 软件版本控制
     * @return 结果
     */
    @Override
    public int updateSoftwareControl(SoftwareControl softwareControl)
    {
        return softwareControlMapper.updateSoftwareControl(softwareControl);
    }

    /**
     * 批量删除软件版本控制
     * 
     * @param ids 需要删除的软件版本控制主键
     * @return 结果
     */
    @Override
    public int deleteSoftwareControlByIds(String ids)
    {
        Long[] idArray = Convert.toLongArray(ids);
        for (Long id:idArray){
            SoftwareControl softwareControl = softwareControlMapper.selectSoftwareControlById(id);
            if (StringUtils.isNotEmpty(softwareControl.getFileName())){
                System.out.println(RuoYiConfig.getSoftwarePath()+softwareControl.getFilePath());
                FileUtils.deleteFile(RuoYiConfig.getSoftwarePath()+softwareControl.getFilePath());
            }
        }
        return softwareControlMapper.deleteSoftwareControlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除软件版本控制信息
     * 
     * @param id 软件版本控制主键
     * @return 结果
     */
    @Override
    public int deleteSoftwareControlById(Long id)
    {
        return softwareControlMapper.deleteSoftwareControlById(id);
    }

    @Override
    public AjaxResult uploadSoftware(MultipartFile file, SysUser user) {




        return null;
    }

    @Override
    public boolean verifyVersion(SoftwareControl softwareControl) {
        String type = softwareControl.getType();
        if (StringUtils.isEmpty(type)){
            SoftwareControl softwareControl1 = softwareControlMapper.selectSoftwareControlById(softwareControl.getId());
            type=softwareControl1.getType();
            if (StringUtils.isEmpty(type)){
                return false;
            }
        }
        SoftwareControl software = softwareControlMapper.selectMaxVersion(type);
        if (software==null){
           return true;
       }
        if (software.getBigVersion()!=null&&software.getMinVersion()!=null){
//            if (softwareControl.getBigVersion()<software.getBigVersion()||softwareControl.getMinVersion()<=software.getMinVersion()){
//                return false;
//            }
            if (software.getBigVersion()<softwareControl.getBigVersion()){
                return true;
            }else if (softwareControl.getBigVersion()==software.getBigVersion()){
                if (softwareControl.getMinVersion()<=software.getMinVersion()){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
