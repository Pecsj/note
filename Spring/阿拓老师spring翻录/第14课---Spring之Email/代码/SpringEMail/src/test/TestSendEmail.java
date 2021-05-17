package test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class TestSendEmail {

    //设计一个方法 创建一个邮件对象
    //  参数? 一个session
    //  返回值? 一个邮件对象(映射) MimeMessage
    private static Message createMessage(Session session) throws MessagingException {
        //自己创建一个邮件对象
        Message message = new MimeMessage(session);
        //设置邮件的基本信息
        //设置发送人
        message.setFrom(new InternetAddress("370917198@qq.com"));
        //设置接收人  recipient容器 收纳     类型 收件人TO 抄送人CC 密送/暗送 BCC
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("370917198@qq.com"));
        //设置发送邮件的时间
//        message.setSentDate(new Date());
        //设置发送主题
        message.setSubject("这是邮件的主题");
        //设置发送邮件正文
        message.setText("我是邮件的正文");

        //以上所有的设置需要保存才能生效
        message.saveChanges();
        //将message对象返回
        return message;
    }

    public static void main(String[] args) throws MessagingException {
        //1.下载一个mail.jar
        //2.导包
        //3.创建一个用于存放配置信息的对象，Properties类型
        Properties prop = new Properties();
        //4.设置发送邮件需要的一些信息
        //设置发送邮件的协议  smtp
        prop.put("mail.transport.protocol","smtp");//必须
        //设置发送邮件的主机名
        prop.put("mail.smtp.host","smtp.qq.com");//必须
        //设置发送邮件的端口 默认25,还有110,143,465
//        prop.put("mail.smtp.port","xxx");
        //设置发送邮件时 是否需要进行身份认证
//        prop.put("mail.smtp.auth","true");
        //设置是否使用ssl安全连接 默认使用
//        prop.put("mail.smtp.ssl.enable","true");
        //5.创建一个Session对象(可以理解为是一个Socket，Java和邮箱之间建立一个连接)
        Session session = Session.getDefaultInstance(prop);
        //6.通过session对象获取一个Transport对象(可以理解为是一个输出流)
        Transport ts = session.getTransport();
        //7.想要通过邮箱发送邮件，必须得到邮件服务器的认证
        ts.connect("370917198@qq.com","sahavtowpilnbifc");
        //8.发送是一封邮件(创建一个邮件的映射关系)     File对象 Class对象  映射
        //  创建邮件对象本身比较复杂 需要好多信息 单独写一个方法
        Message message = createMessage(session);
        //9.发送邮件(需要一个message对象，知道message对象中的那些接收人)
        ts.sendMessage(message,message.getAllRecipients());
        //10.关闭通道
        ts.close();
        System.out.println("发送完毕");
    }
}
