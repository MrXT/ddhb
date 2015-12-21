package com.manzz.framework.core.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import com.manzz.framework.core.common.Constants;
/**
 * 电子邮件工具类
 * @author WUJK
 * @version 2013-05
 */
public class EmailUtils {
    private static transient Log logger = LogFactory.getLog(EmailUtils.class);
    
    private final static String EMAIL_SMTP_HOST    = CommonUtils.readResource("email.smtp.host");
    private final static String EMAIL_SENDER_ADDR = CommonUtils.readResource("email.sender.addr");
    private final static String EMAIL_SENDER_NAME = CommonUtils.readResource("email.sender.name");
    private final static String EMAIL_USER_NAME   = CommonUtils.readResource("email.user.name");
    private final static String EMAIL_USER_PWD    = CommonUtils.readResource("email.user.pwd");
    private final static String[] EMAIL_ATTACHMENT_PATH = CommonUtils.readResource("email.attachment.path").split(",");
    private final static String[] EMAIL_ADMIN_ADDRESS = CommonUtils.readResourceArray("email.admin.address");
    
    /**
     * 发送邮件给管理员
     * @param subject 邮件标题
     * @param msg     邮件内容
     */
    public static void sendMailToAdmin(String subject, String msg) {
        for(String adminAddr : EMAIL_ADMIN_ADDRESS){
            sendTextMail(adminAddr, subject, msg);
        }
    }
    
    /**
     * 发送纯文本邮件
     * @param toAddr  收信人邮件地址
     * @param subject 邮件标题
     * @param msg     邮件内容
     */
    public static void sendTextMail(String toAddr, String subject, String msg) {
        //使用apache的commons-email.jar来实现
        try {
            SimpleEmail email = new SimpleEmail();
            email.setCharset(Constants.DEFAULT_WEB_ENCODING);
            email.setHostName(EMAIL_SMTP_HOST);
            email.addTo(toAddr);
            email.setFrom(EMAIL_SENDER_ADDR, EMAIL_SENDER_NAME);// 设置邮件名称
            email.setAuthentication(EMAIL_USER_NAME, EMAIL_USER_PWD);
            email.setSubject(subject);  
            email.setMsg(msg);  
            email.send();  
        } catch (Exception e) {
            logger.error("发送邮件,邮件地址:" + toAddr + " 标题:" + subject + " 内容:" + msg + "失败! 原因是" + e.getMessage());
        }   
        //方法二：直接使用javaMail的写法      
//        try {
//            Properties props = new Properties();
//            props.put("mail.smtp.host", MAIL_SMTP_HOST);
//            props.put("mail.smtp.auth", "true");
//            // 基本的邮件会话
//            Session session = Session.getDefaultInstance(props, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(EMAIL_USER_NAME, EMAIL_USER_PWD);
//                }
//            });
//
//            //session.setDebug(true);// 设置调试标志,要查看经过邮件服务器邮件命令，可以用该方法
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(SENDER_EMAIL_ADDR, SENDER_EMAIL_NAME,"UTF-8"));// 发件地址
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddr));// 收件地址
//            message.setSubject(subject);    // 设置主题
//            message.setText(msg);           // 设置信件内容
//            message.setSentDate(new Date());// 设置发信时间
//            message.saveChanges();          // 存储邮件信息
//            Transport.send(message);        // 发送邮件
//        } catch (Exception e) {
//            logger.error("发送邮件,邮件地址:" + toAddr + " 标题:" + subject + " 内容:" + msg + "失败! 原因是" + e.getMessage());
//        }
    }
    
    /**
     * 发送带默认附件的邮件
     * @param toAddr  收信人邮件地址
     * @param subject 邮件标题
     * @param msg     邮件内容
     */
    public static void sendAttachmentMail(String toAddr, String subject, String msg){
        sendAttachmentMail(toAddr, subject, msg, EMAIL_ATTACHMENT_PATH);
    }
    
    /**
     * 发送带指定附件的邮件
     * @param toAddr  收信人邮件地址
     * @param subject 邮件标题
     * @param msg     邮件内容
     * @param attachmentPath 附件地址
     */
    public static void sendAttachmentMail(String toAddr, String subject, String msg, String... attachmentPath){
        try {
            List<EmailAttachment> attachmentList = new ArrayList<EmailAttachment>();
            for (int i = 0; i < attachmentPath.length; i++) {
                EmailAttachment attachment = new EmailAttachment();
                // 判断当前这个文件路径是否在本地
                if (attachmentPath[i].indexOf("http") == -1) {
                    // 本地附件
                    attachment.setPath(attachmentPath[i]);
                } else {
                    // 网络附件
                    attachment.setURL(new URL(attachmentPath[i]));
                }
                attachment.setDescription(EmailAttachment.ATTACHMENT);
                try {
                    File file = new File(attachmentPath[i]);
                    // 设置附件名称（支持中文）
                    attachment.setName(MimeUtility.encodeText(file.getName().toString()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                attachmentList.add(attachment);
            }

            //创建一个email   
            MultiPartEmail multiPartEmail = new MultiPartEmail();
            multiPartEmail.setHostName(EMAIL_SMTP_HOST);
            multiPartEmail.addTo(toAddr);
            multiPartEmail.setFrom(EMAIL_SENDER_ADDR, EMAIL_SENDER_NAME);
            multiPartEmail.setAuthentication(EMAIL_USER_NAME, EMAIL_USER_PWD);
            multiPartEmail.setCharset(Constants.DEFAULT_WEB_ENCODING);
            multiPartEmail.setSubject(subject);
            multiPartEmail.setMsg(msg);
            for(int j=0;j<attachmentList.size();j++){
                multiPartEmail.attach(attachmentList.get(j));
            }
            multiPartEmail.send();
        } catch (Exception e) {
            logger.error("发送邮件,邮件地址:" + toAddr + " 标题:" + subject + " 内容:" + msg + "失败! 原因是" + e.getMessage());
        }   
    }
    
    /**
     * 发送带HTML格式的邮件（不支持内嵌图片）
     * @param toAddr  收信人邮件地址
     * @param subject 邮件标题
     * @param htmlMsg html格式的邮件
     */
    public static void sendHtmlMail(String toAddr, String subject, String htmlMsg){
        try {
            HtmlEmail htmlEmail = new HtmlEmail();
            htmlEmail.setHostName(EMAIL_SMTP_HOST);
            htmlEmail.addTo(toAddr);
            htmlEmail.setFrom(EMAIL_SENDER_ADDR, EMAIL_SENDER_NAME);
            htmlEmail.setAuthentication(EMAIL_USER_NAME, EMAIL_USER_PWD);
            htmlEmail.setCharset(Constants.DEFAULT_WEB_ENCODING);
            htmlEmail.setSubject(subject);
            // 如果html中需要带图片参考以下方式重新扩展
//            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
//            String cid = email.embed(url, "Apache logo");
//            htmlEmail.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");
            htmlEmail.setHtmlMsg(htmlMsg);
            htmlEmail.setTextMsg("您的邮箱不支持html格式的消息");
            htmlEmail.send();

        } catch (Exception e) {
            logger.error("发送邮件,邮件地址:" + toAddr + " 标题:" + subject + " 内容:" + htmlMsg + "失败! 原因是" + e.getMessage());
        }   
    }

    public static void main(String[] args) throws Exception {
        sendTextMail("wjk615@163.com", "邮件发送测试", "邮件发送成功啦，恭喜!");
        //sendAttachmentMail("wujk@ceair.com", "带附件发送测试", "邮件发送成功啦，恭喜");
        //String[] attachmentPath = new String[] { "D:/fmis.log", "D:/工作备忘.txt"};
        //sendAttachmentMail("wujk@ceair.com", "带附件发送测试", "邮件发送成功啦，恭喜", attachmentPath);
        //sendHtmlMail("wujk@ceair.com", "带html发送测试", "<html><b>The apache logo</b> </html>");
    }
}
