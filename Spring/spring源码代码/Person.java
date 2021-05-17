package com.video.spring;


import lombok.Data;

@Data
public class Person {

    private int id;
    private String name;

    public Person() {

        System.out.println("Person 构造方法");
    }

    public void init1() {
        System.out.println("Person init1");

    }

    public void destory1() {
        System.out.println("Person destory1");
    }
}
