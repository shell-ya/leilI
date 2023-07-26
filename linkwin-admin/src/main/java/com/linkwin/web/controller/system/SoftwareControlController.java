package com.linkwin.web.controller.system;

import java.util.List;

import com.linkwin.activity.domain.ActivityManager;
import com.linkwin.apply.domain.BarCodeApply;
import com.linkwin.common.config.RuoYiConfig;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.utils.ShiroUtils;
import com.linkwin.common.utils.file.FileUploadUtils;
import com.linkwin.common.utils.file.FileUtils;
import com.linkwin.system.domain.SoftwareControl;
import com.linkwin.system.service.ISoftwareControlService;
import com.linkwin.utils.ConfConst;
import lombok.extern.slf4j.Slf4j;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 软件版本控制Controller
 * 
 * @author ruoyi
 * @date 2022-09-19
 */
@Slf4j
@Controller
@RequestMapping("/system/software")
public class SoftwareControlController extends BaseController
{
    private String prefix = "system/software";

    @Autowired
    private ISoftwareControlService softwareControlService;

    @RequiresPermissions("system:software:view")
    @GetMapping()
    public String control()
    {
        return prefix + "/software";
    }

    /**
     * 查询软件版本控制列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SoftwareControl softwareControl)
    {
        startPage();
        List<SoftwareControl> list = softwareControlService.selectSoftwareControlList(softwareControl);
        return getDataTable(list);
    }

    @RequiresPermissions("system:software:upload")
    @GetMapping("/upload/{id}")
    public String upload(@PathVariable String id,ModelMap mmap)
    {
        mmap.put("id",id);
        return prefix + "/upload";
    }

    /**
     * 导出软件版本控制列表
     */
    @Log(title = "软件版本控制", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SoftwareControl softwareControl)
    {
        List<SoftwareControl> list = softwareControlService.selectSoftwareControlList(softwareControl);
        ExcelUtil<SoftwareControl> util = new ExcelUtil<SoftwareControl>(SoftwareControl.class);
        return util.exportExcel(list, "软件版本控制数据");
    }

    /**
     * 新增软件版本控制
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存软件版本控制
     */
    @Log(title = "软件版本控制", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SoftwareControl softwareControl)
    {
        boolean b = softwareControlService.verifyVersion(softwareControl);
        if (!b){
            return AjaxResult.error("版本号必须大于历史版本号");
        }
        SysUser sysUser = ShiroUtils.getSysUser();
        softwareControl.setUpUserId(sysUser.getUserId());
        softwareControl.setUpUserName(sysUser.getUserName());
        return toAjax(softwareControlService.insertSoftwareControl(softwareControl));
    }

    /**
     * 修改软件版本控制
     */
    @RequiresPermissions("system:software:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SoftwareControl softwareControl = softwareControlService.selectSoftwareControlById(id);
        mmap.put("softwareControl", softwareControl);
        return prefix + "/edit";
    }

    /**
     * 修改保存软件版本控制
     */
    @Log(title = "软件版本控制", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SoftwareControl softwareControl)
    {
        boolean b = softwareControlService.verifyVersion(softwareControl);
        if (!b){
            return AjaxResult.error("版本号必须大于历史版本号");
        }
        return toAjax(softwareControlService.updateSoftwareControl(softwareControl));
    }

    /**
     * 删除软件版本控制
     */
    @Log(title = "软件版本控制", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(softwareControlService.deleteSoftwareControlByIds(ids));
    }




    /**
     * 上传软件
     */
    @PostMapping("/uploadSoftware/{id}")
    @ResponseBody
    public AjaxResult uploadFiles(MultipartFile files,@PathVariable Long id) throws Exception
    {
        try
        {
            RuoYiConfig.getSoftwarePath();
            String path = FileUploadUtils.upload(RuoYiConfig.getSoftwarePath(), files);
            path=path.replace("/profile/software","");
            int i = path.lastIndexOf("/");
            String fileName = path.substring(i+1);
            SoftwareControl softwareControl = softwareControlService.selectSoftwareControlById(id);
            softwareControl.setFilePath(path);
            softwareControl.setSize(files.getSize());
            softwareControl.setFileName(fileName);
            softwareControlService.updateSoftwareControl(softwareControl);
            return AjaxResult.success("上传成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return AjaxResult.error("上传失败");
        }
    }

    /**
     * 修改软件使用状态
     */
    @Log(title = "修改活动状态", businessType = BusinessType.UPDATE)
    @PostMapping( "/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SoftwareControl softwareControl)
    {
        return toAjax(softwareControlService.updateSoftwareControl(softwareControl));
    }

    @Log(title = "下载软件", businessType = BusinessType.EXPORT)
    @GetMapping("/downLoad")
    @ResponseBody
    public void downLoad(Long id, HttpServletRequest request, HttpServletResponse response){
        try {
            SoftwareControl softwareControl = softwareControlService.selectSoftwareControlById(id);
            String path=RuoYiConfig.getSoftwarePath()+softwareControl.getFilePath();
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, softwareControl.getFileName()));
            FileUtils.writeBytes(path, response.getOutputStream());
        }catch (Exception e){
            log.error("SoftwareControlController downLoad is error 下载软件异常",e);
        }
    }


}
