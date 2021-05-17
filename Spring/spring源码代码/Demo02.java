package com.video.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml");

        // 创建事件
        MyApplicationEvent event = new MyApplicationEvent("事件内容", "james", "123@qq.com");


        context.publishEvent(event);

        context.close();


    }
}
