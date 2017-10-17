package cn.liweifa.mail.service.impl;

/**
 * Created by josli on 17/10/17.
 */
public interface MailService {

     void sendText(String text);

     void sendHtml(String html);
     void sendHtml();



}
