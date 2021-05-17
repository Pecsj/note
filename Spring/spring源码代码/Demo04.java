package com.video.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo04 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");

        UserA user = (UserA) context.getBean("userA");
        System.out.println(user);

        context.close();


    }
}
