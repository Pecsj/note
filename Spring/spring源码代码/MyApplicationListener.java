package com.video.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 事件的回调方法

        System.out.println("接收到的事件：" + event);
        if (event instanceof MyApplicationEvent) {
            MyApplicationEvent myApplicationEvent = (MyApplicationEvent) event;
            System.out.println("用户：" + myApplicationEvent.getUsername());
            System.out.println("邮箱：" + myApplicationEvent.getEmail());
        }
    }
}
