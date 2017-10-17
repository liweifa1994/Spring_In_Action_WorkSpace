package cn.liweifa.mail.service;

import org.springframework.mail.MailException;

import javax.mail.MessagingException;

/**
 * Created by josli on 17/10/17.
 */
public interface EmailService {

    boolean sendText(MailPojo mailPojo) throws MailException;

    boolean sendHtml(MailPojo mailPojo) throws MessagingException;

}
