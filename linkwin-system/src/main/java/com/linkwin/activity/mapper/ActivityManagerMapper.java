package com.linkwin.activity.mapper;

import com.linkwin.activity.domain.ActivityManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-30
 */
public interface ActivityManagerMapper 
{
    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    public ActivityManager selectActivityManagerById(Long id);

    /**
     * 查询活动管理列表
     * 
     * @param activityManager 活动管理
     * @return 活动管理集合
     */
    public List<ActivityManager> selectActivityManagerList(ActivityManager activityManager);

    /**
     * 新增活动管理
     * 
     * @param activityManager 活动管理
     * @return 结果
     */
    public int insertActivityManager(ActivityManager activityManager);

    /**
     * 修改活动管理
     * 
     * @param activityManager 活动管理
     * @return 结果
     */
    public int updateActivityManager(ActivityManager activityManager);

    /**
     * 删除活动管理
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    public int deleteActivityManagerById(Long id);

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteActivityManagerByIds(String[] ids);

    /**
     * 根据产品获取一个活动
     * @param pdCode
     * @return
     */
    ActivityManager getOneActivity(String pdCode);

    /**
     * 根据产品编码及状态活动启用中的产品
     * @param pdCode
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/20
     */
    int getActivityByPdCodeAndStatus(String pdCode);


    /**
     *
     * @param pdCode
     * @param activityType
     * @return
     */
    ActivityManager getOneActivityByType(@Param("pdCode") String pdCode, @Param("activityType") String activityType);


}
