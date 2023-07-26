package com.linkwin.web.controller.activity;

import java.util.List;

import com.linkwin.activity.domain.ActivityManager;
import com.linkwin.activity.service.IActivityManagerService;
import com.linkwin.basedata.domain.AllProduct;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.common.config.RuoYiConfig;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.common.utils.file.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 活动管理Controller
 * 
 * @author ruoyi
 * @date 2022-05-30
 */
@Controller
@RequestMapping("/activity/manager")
public class ActivityManagerController extends BaseController
{
    private String prefix = "activity/manager";

    @Autowired
    private IActivityManagerService activityManagerService;

    @Autowired
    private IProductService productService;

    @RequiresPermissions("activity:manager:view")
    @GetMapping()
    public String manager()
    {
        return prefix + "/manager";
    }

    /**
     * 查询活动管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActivityManager activityManager)
    {
        startPage();
        List<ActivityManager> list = activityManagerService.selectActivityManagerList(activityManager);
        return getDataTable(list);
    }

    /**
     * 导出活动管理列表
     */
    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActivityManager activityManager)
    {
        List<ActivityManager> list = activityManagerService.selectActivityManagerList(activityManager);
        ExcelUtil<ActivityManager> util = new ExcelUtil<ActivityManager>(ActivityManager.class);
        return util.exportExcel(list, "活动管理数据");
    }

    /**
     * 新增活动管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<AllProduct> productList = productService.selectAllProductList(new Product());
        mmap.put("productList",productList);
        return prefix + "/add";
    }
    @GetMapping("/detail/{id}")
    public String detail(ModelMap mmap,@PathVariable("id") Long id)
    {
         mmap.put("activityid",id);
        return "activity/activityConfigPrize/prize";
    }

    /**
     * 新增保存活动管理
     */
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActivityManager activityManager)
    {
        Product product = productService.selectByPdCode(activityManager.getPdCode());
        activityManager.setPdName(product.getName());
        return toAjax(activityManagerService.insertActivityManager(activityManager));
    }

    /**
     * 修改活动管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActivityManager activityManager = activityManagerService.selectActivityManagerById(id);
        List<AllProduct> productList = productService.selectAllProductList(new Product());
        mmap.put("productList",productList);
        mmap.put("activityManager", activityManager);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动管理
     */
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActivityManager activityManager)
    {
        return toAjax(activityManagerService.updateActivityManager(activityManager));
    }

    /**
     * 删除活动管理
     */
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(activityManagerService.deleteActivityManagerByIds(ids));
    }


    /**
     * 修改活动状态
     */
    @Log(title = "修改活动状态", businessType = BusinessType.UPDATE)
    @PostMapping( "/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(ActivityManager activityManager)
    {
        if (activityManager.getStatus()==1){
            ActivityManager activityManager1 = activityManagerService.selectActivityManagerById(activityManager.getId());
            int isUse = activityManagerService.getActivityByPdCodeAndStatus(activityManager1.getPdCode());
            if (isUse>0){
//                return AjaxResult.error("该产品有其他正在进行中的活动，请先暂停其他活动！");
                return AjaxResult.error(MessageUtils.message("error.msg.otheractivity"));
            }
        }
        return toAjax(activityManagerService.updateActivityManager(activityManager));
    }
    /**
     * 修改产品信息
     */
    @GetMapping("/editimg/{id}")
    public String editimg(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActivityManager activityManager = activityManagerService.selectActivityManagerById(id);
        mmap.put("activityManager", activityManager);
        mmap.put("truntablePath",activityManager.getTruntablePath());
        return prefix + "/imgedit";
    }

    @GetMapping("/avatar/{id}")
    public String avatar(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActivityManager activityManager = activityManagerService.selectActivityManagerById(id);
        mmap.put("activityManager", activityManager);
        mmap.put("ids" ,activityManager.getId());
        return prefix + "/avatar";

    }

    /**
     * 保存产品解释
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatar/{id}")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file , @PathVariable("id") Long id)
    {
        ActivityManager activityManager = activityManagerService.selectActivityManagerById(id);
        try
        {
            if (!file.isEmpty())
            {
                String avatar = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
                activityManager.setTruntablePath(avatar);
                if (activityManagerService.updateActivityManager(activityManager) > 0)
                {

                    return success();
                }
            }
            return error();
        }
        catch (Exception e)
        {

            e.printStackTrace();
            return error(e.getMessage());
        }
    }




}
