package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class SpringSendEmail {

    public static void main(String[] args) throws MessagingException {
        //1.跟SpringBeanFactory要一个对象
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        JavaMailSender sender = (JavaMailSender)factory.getBean("sender");//JavaMailSenderImpl
        //2.利用这个sender创建一个邮件对象
        MimeMessage message = sender.createMimeMessage();
        //3.发送这个邮件  找小弟帮忙
        MimeMessageHelper helper = new MimeMessageHelper(message);//是刚才那个Session和Transport的合体
        //4.需要告知helper 发给谁 发什么
        helper.setFrom("370917198@qq.com");//设置发送的地址
        helper.setTo("370917198@qq.com");//设置收件人地址
        helper.setSubject("基于Spring的新主题");
        helper.setText("基于Spring的新内容");//验证的地址(新请求 认证成功)
        //5.直接发送消息
        sender.send(message);
        System.out.println("基于Spring发送成功");
    }
}
