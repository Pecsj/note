package com.video.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo05 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring5.xml");

        User user = (User) context.getBean("user");
        System.out.println(user);

        context.close();


    }
}
