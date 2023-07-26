package com.linkwin.mail.impl;

import com.linkwin.common.config.MailConfig;
import com.linkwin.common.utils.CacheUtils;
import com.linkwin.mail.IMailService;
import com.linkwin.utils.CodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private TemplateEngine templateEngine;
//    @Autowired
//    private ServletContext servletContext;

    @Override
    public void sendMail2Code(String targetEmail, String subject) throws MessagingException {
        try{
            String code = CodeUtils.getIntegralCode(6);
            CacheUtils.put(targetEmail,code);
            Context context = new Context();
            context.setVariable("code",code);

            String mailCode = templateEngine.process("mail/VerificationCode", context);
            this.sendMail(targetEmail,mailConfig.getSubject(),mailCode);
        }catch (Exception e){
            log.error("发送邮件错误",e);
            throw e;
        }
    }

    @Override
    public void sendMail(String targetEmail, String subject, String context) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setFrom(mailConfig.getUsername());
        helper.setTo(targetEmail);
        helper.setSubject(subject);
        helper.setText(context,true);
        javaMailSender.send(mimeMessage);
    }
}
