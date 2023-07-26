package com.linkwin.web.controller.openInterface;


import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/user")
@Controller
public class UserScanH5Controller extends BaseController {

    private static String prefix="h5/distributeLogin";

    /**
     * 海外用户登录
     * @return
     */
    @GetMapping("login")
    public String exchangeLogin(String checkAddress, ModelMap mmap){
        mmap.put("checkAddress",checkAddress);
        return prefix+"/login";
    }

    @GetMapping("externalScan")
    public String scan(String checkAddress, ModelMap mmap){
        mmap.put("checkAddress",checkAddress);
        return prefix+"/htScan";
    }



}
