package cn.liweifa.mail.test;

import cn.liweifa.mail.config.MailConfig;
import cn.liweifa.mail.service.impl.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by josli on 17/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MailConfig.class)
public class MailTest {

    @Autowired
    private MailService mailService;
    @Test
    public void testEmail()throws Exception{
//        mailService.sendText("hello");
//        mailService.sendHtml("1231");
//        System.out.println("hello world");
        mailService.sendHtml();
    }
}
