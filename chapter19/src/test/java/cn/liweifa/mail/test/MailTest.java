package cn.liweifa.mail.test;

import cn.liweifa.mail.config.MailConfig;
import cn.liweifa.mail.service.EmailService;
import cn.liweifa.mail.service.MailPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by josli on 17/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MailConfig.class)
public class MailTest {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private EmailService emailService;
    @Test
    public void testSendHtml()throws Exception{
        Context context = new Context();
        context.setVariable("param1","hello world");
        context.setVariable("param2","123123");
        String process = springTemplateEngine.process("index", context);

        MailPojo mailPojo = new MailPojo();
        mailPojo.setSubject("abcdef");
        mailPojo.setText(process);
        mailPojo.setToUser("2414270508@qq.com");
        mailPojo.setFormUser("rxxx");
        emailService.sendHtml(mailPojo);
    }


    @Test
    public void testSendText()throws Exception{
        MailPojo mailPojo = new MailPojo();
        mailPojo.setSubject("abcdef");
        mailPojo.setText("helloword");
        mailPojo.setToUser("xxxx");
        mailPojo.setFormUser("xxx");
        emailService.sendText(mailPojo);

    }
}
