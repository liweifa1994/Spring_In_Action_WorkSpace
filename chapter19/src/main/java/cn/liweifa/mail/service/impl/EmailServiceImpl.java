package cn.liweifa.mail.service.impl;

import cn.liweifa.mail.service.EmailService;
import cn.liweifa.mail.service.MailPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by josli on 17/10/17.
 */
@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public boolean sendText(MailPojo mailPojo) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailPojo.getFormUser());
        mailMessage.setTo(mailPojo.getToUser());
        mailMessage.setSubject(mailPojo.getSubject());
        mailMessage.setText(mailMessage.getText());
        javaMailSender.send(mailMessage);
        return true;
    }

    @Override
    public boolean sendHtml(MailPojo mailPojo) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //创建带有附件功能的helper
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(mailPojo.getFormUser());
        mimeMessageHelper.setTo(mailPojo.getToUser());
        mimeMessageHelper.setSubject(mailPojo.getSubject());
        //指定发送html
        mimeMessageHelper.setText(mailPojo.getText(),true);
        javaMailSender.send(mimeMessage);
        return true;
    }


}
