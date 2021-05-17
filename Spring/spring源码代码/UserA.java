package com.video.spring;

public class UserA {

    UserB userB;

    public UserA() {
    }

    public UserA(UserB userB) {

    }

    public UserB getUserB() {
        return userB;
    }

    public void setUserB(UserB userB) {
        this.userB = userB;
    }
}
