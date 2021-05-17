package com.video.spring;


import lombok.Data;

@Data
public class User {

    private int id;
    private String name;

    public User() {

        System.out.println("user 构造方法");
    }

    public void init1() {
        System.out.println("User init1");

    }

    public void destory1() {
        System.out.println("User destory1");
    }
}
