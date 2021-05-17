package com.video.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Demo01 {

//    IOC
//    AOP

    //    user 构造方法
//    User init1
//    User destory1
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        User user = (User) context.getBean("userFac");

        System.out.println(user);


        MessageSource ms = (MessageSource) context.getBean("messageSource");

//        String name = ms.getMessage("name", null, "def", new Locale("zh", "CN"));
        String name = ms.getMessage("name", null, "def", new Locale("en", "US"));

        System.out.println(name);

        // 关闭spring
        context.close();


    }
}
