package com.video.spring;

import org.springframework.context.ApplicationEvent;


public class MyApplicationEvent extends ApplicationEvent {

    String username;
    String email;

    public MyApplicationEvent(Object source) {
        super(source);
    }

    public MyApplicationEvent(Object source, String username, String email) {
        super(source);
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
