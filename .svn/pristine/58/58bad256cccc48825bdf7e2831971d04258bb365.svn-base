package com.linkwin.activity.service.impl;

import java.util.List;

import com.linkwin.activity.domain.ActivityManager;
import com.linkwin.activity.mapper.ActivityManagerMapper;
import com.linkwin.activity.service.IActivityManagerService;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 活动管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-30
 */
@Service
public class ActivityManagerServiceImpl implements IActivityManagerService
{
    @Autowired
    private ActivityManagerMapper activityManagerMapper;

    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    @Override
    public ActivityManager selectActivityManagerById(Long id)
    {
        return activityManagerMapper.selectActivityManagerById(id);
    }

    /**
     * 查询活动管理列表
     * 
     * @param activityManager 活动管理
     * @return 活动管理
     */
    @Override
    public List<ActivityManager> selectActivityManagerList(ActivityManager activityManager)
    {
        return activityManagerMapper.selectActivityManagerList(activityManager);
    }

    /**
     * 新增活动管理
     * 
     * @param activityManager 活动管理
     * @return 结果
     */
    @Override
    public int insertActivityManager(ActivityManager activityManager)
    {
        SysUser sysUser = ShiroUtils.getSysUser();
        activityManager.setCreateId(sysUser.getUserId());
        activityManager.setCreateName(sysUser.getUserName());
        activityManager.setCreateTime(DateUtils.getNowDate());
        return activityManagerMapper.insertActivityManager(activityManager);
    }

    /**
     * 修改活动管理
     * 
     * @param activityManager 活动管理
     * @return 结果
     */
    @Override
    public int updateActivityManager(ActivityManager activityManager)
    {
        return activityManagerMapper.updateActivityManager(activityManager);
    }

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的活动管理主键
     * @return 结果
     */
    @Override
    public int deleteActivityManagerByIds(String ids)
    {
        return activityManagerMapper.deleteActivityManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动管理信息
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    @Override
    public int deleteActivityManagerById(Long id)
    {
        return activityManagerMapper.deleteActivityManagerById(id);
    }

    @Override
    public ActivityManager getOneActivity(String pdCode) {
        return activityManagerMapper.getOneActivity(pdCode);
    }

    @Override
    public int getActivityByPdCodeAndStatus(String pdCode) {
        return activityManagerMapper.getActivityByPdCodeAndStatus(pdCode);
    }

    @Override
    public ActivityManager getOneActivityByType(String pdCode, String activityType) {
        return activityManagerMapper.getOneActivityByType(pdCode,activityType);
    }

}
