package com.linkwin.web.controller.apply;

import java.util.Date;
import java.util.List;

import com.linkwin.apply.domain.BoxCodeApply;
import com.linkwin.apply.domain.BoxCodeApplyStatusMenu;
import com.linkwin.apply.service.IBoxCodeApplyService;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.common.utils.ShiroUtils;
import com.linkwin.common.utils.file.FileUtils;
import com.linkwin.system.service.ISysConfigService;
import com.linkwin.utils.ConfConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
@Slf4j
@Controller
@RequestMapping("/apply/boxApply")
public class BoxCodeApplyController extends BaseController
{
    private String prefix = "apply/boxApply";

    @Autowired
    private IBoxCodeApplyService boxCodeApplyService;

    @Autowired
    private ISysConfigService sysConfigService;

    @RequiresPermissions("apply:boxcode:view")
    @GetMapping()
    public String apply()
    {
        return prefix + "/apply";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BoxCodeApply boxCodeApply)
    {
        startPage();
        List<BoxCodeApply> list = boxCodeApplyService.selectBoxCodeApplyList(boxCodeApply);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BoxCodeApply boxCodeApply)
    {
        List<BoxCodeApply> list = boxCodeApplyService.selectBoxCodeApplyList(boxCodeApply);
        ExcelUtil<BoxCodeApply> util = new ExcelUtil<BoxCodeApply>(BoxCodeApply.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BoxCodeApply boxCodeApply)
    {
        return addAfterDeal(boxCodeApply);
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:apply:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BoxCodeApply boxCodeApply = boxCodeApplyService.selectBoxCodeApplyById(id);
        mmap.put("boxCodeApply", boxCodeApply);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:apply:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BoxCodeApply boxCodeApply)
    {
        return toAjax(boxCodeApplyService.updateBoxCodeApply(boxCodeApply));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:apply:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(boxCodeApplyService.deleteBoxCodeApplyByIds(ids));
    }


    @Log(title = "下载条码", businessType = BusinessType.EXPORT)
    @GetMapping("/downLoad")
    @ResponseBody
    public void downLoad(Long id, HttpServletRequest request, HttpServletResponse response){
        try {
            BoxCodeApply boxCodeApply = boxCodeApplyService.selectBoxCodeApplyById(id);
            if (boxCodeApply.getIsDownload().equals("0")){
                boxCodeApply.setIsDownload("1");//改为已下载
            }
            if (boxCodeApply.getDownloadNum()>=boxCodeApply.getDownloadMaxNum()){
                return;
            }
            boxCodeApply.setDownloadNum(boxCodeApply.getDownloadNum()+1);//下载次数+1
            boxCodeApplyService.updateBoxCodeApply(boxCodeApply);
            String path=boxCodeApply.getFilePath();
            String dir = sysConfigService.selectConfigByKey(ConfConst.BOX_CODE_FILE_PATH);
            path=dir+path;
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, boxCodeApply.getFileName()));
            FileUtils.writeBytes(path, response.getOutputStream());
        }catch (Exception e){
            log.error("BarCodeApplyController downLoad is error",e);
        }
    }

    @PostMapping("/queryPassword")
    @ResponseBody
    public AjaxResult queryPassword(Long id){
        BoxCodeApply boxCodeApply = boxCodeApplyService.selectBoxCodeApplyById(id);
        if (!boxCodeApply.getCreator().equals(ShiroUtils.getSysUser().getUserName())){
//            return AjaxResult.error("您没有权限查看该码包密码");
            return AjaxResult.error(MessageUtils.message("error.msg.nothavepermission"));
        }
        return AjaxResult.ok(boxCodeApply.getPassword(),MessageUtils.message("success"));
//        return AjaxResult.ok(boxCodeApply.getPassword(),"成功");
    }

    @PostMapping("/setMaxDown")
    @ResponseBody
    public AjaxResult queryPassword(BoxCodeApply boxCodeApply){
        return toAjax(boxCodeApplyService.updateBoxCodeApply(boxCodeApply));
    }


    public AjaxResult addAfterDeal(BoxCodeApply boxCodeApply) {
        int applyMax=500000;
        boxCodeApply.setCreator(ShiroUtils.getSysUser().getUserName());
        boxCodeApply.setCreateTime(new Date());
//        Integer bumaRate = boxCodeApply.getBumaRate();
        double bumaRate = boxCodeApply.getBumaRate().doubleValue() / 100;
        if (bumaRate<0||bumaRate>1){
//            return AjaxResult.error("请输入正确补码率");
            return AjaxResult.error(MessageUtils.message("error.msg.entercorrectrate"));
        }
        boxCodeApply.setBumaNum((int) Math.round(bumaRate * boxCodeApply.getApplyNum()));//补码数量
        boxCodeApply.setTotalNum(boxCodeApply.getApplyNum()+ boxCodeApply.getBumaNum());//申请总数
        if (boxCodeApply.getTotalNum()>applyMax){
//            return AjaxResult.error(String.format("申请条码总数量不可超过%d条", applyMax));
            return AjaxResult.error(String.format(MessageUtils.message("error.msg.totalnumber"), applyMax));
        }
        boxCodeApply.setStatus(BoxCodeApplyStatusMenu.HANDLE_STATUS_NONE.getValue());//未生成
        boxCodeApply.setIsDownload("0");//下载状态
        boxCodeApply.setDownloadNum(0);//已下载次数
        boxCodeApply.setExistNum(0);//已生成数量
        boxCodeApply.setDownloadMaxNum(1);//最大下载次数
        return toAjax(boxCodeApplyService.insertBoxCodeApply(boxCodeApply));
    }

}
