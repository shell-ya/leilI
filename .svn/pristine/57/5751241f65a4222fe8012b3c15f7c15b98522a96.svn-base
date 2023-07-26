package com.linkwin.web.controller.mail;

import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.mail.IMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/email")
@RestController
public class MailController {

    @Resource
    private IMailService mailService;

    @PostMapping("/send")
    public AjaxResult sendCode(String email){
        if (StringUtils.isEmpty(email)){
            return AjaxResult.error("邮箱不能为空");
        }
        try{
//            mailService.sendMail2Code(email,"登录", request, response);
        }catch (Exception e){
            log.error("�ʼ����ʹ���",e);
            return AjaxResult.error();
        }
        return AjaxResult.success("已发送验证码请在三分钟内完成校验");
    }
}
