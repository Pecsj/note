package com.video.spring;

public class UserB {

    UserA userA;

    public UserB() {
    }

    public UserB(UserA userA) {

    }

    public UserA getUserA() {
        return userA;
    }

    public void setUserA(UserA userA) {
        this.userA = userA;
    }
}
