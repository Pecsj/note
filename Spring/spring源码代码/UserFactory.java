package com.video.spring;


import lombok.Data;

@Data
public class UserFactory {


    public static User createUser() {
        return new User();
    }
}
