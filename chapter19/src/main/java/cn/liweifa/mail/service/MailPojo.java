package cn.liweifa.mail.service;

/**
 * Created by josli on 17/10/17.
 */
public class MailPojo {
    /**
     * @param formUser 邮件的发送者
     * @param toUser 邮件的接收者
     * @param subject 邮件的标题
     * @param text 发送的内容
     */
    private String formUser;
    private String toUser;
    private String text ;
    private String subject;

    public String getFormUser() {
        return formUser;
    }

    public void setFormUser(String formUser) {
        this.formUser = formUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
