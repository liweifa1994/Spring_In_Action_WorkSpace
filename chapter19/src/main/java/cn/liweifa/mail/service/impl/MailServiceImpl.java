package cn.liweifa.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

/**
 * Created by josli on 17/10/17.
 */
@Component
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;


    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Override
    public void sendText(String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("2414270508@qq.com");
        mailMessage.setTo("2414270508@qq.com");
        mailMessage.setSubject("制卡程序出错了");
        mailMessage.setText("exception error 今天上午测试了 15");
        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendHtml(String html) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //构造参数 第二个表明这是一个 multipart
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("2414270508@qq.com");
            mimeMessageHelper.setTo("2414270508@qq.com");
            mimeMessageHelper.setSubject("制卡程序出错了");
            mimeMessageHelper.setText("exception error 今天上午测试了 15");
            FileSystemResource fileSystemResource = new FileSystemResource("/Users/josli/002/CardMakingCP2Printer/build.xml");
            mimeMessageHelper.addAttachment("kargocartools", fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {

        }
    }

    @Override
    public void sendHtml() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //构造参数 第二个表明这是一个 multipart
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("2414270508@qq.com");
            mimeMessageHelper.setTo("2414270508@qq.com");
            mimeMessageHelper.setSubject("制卡程序出错了");
            Context context = new Context();
            context.setVariable("param1","hello world");
            context.setVariable("param2","123123");
            String process = springTemplateEngine.process("index", context);
            mimeMessageHelper.setText(process,true);
            FileSystemResource fileSystemResource = new FileSystemResource("/Users/josli/002/CardMakingCP2Printer/build.xml");
            mimeMessageHelper.addAttachment("kargocartools.xml", fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {

        }
    }
}
