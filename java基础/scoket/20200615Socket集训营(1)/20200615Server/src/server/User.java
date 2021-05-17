package server;

import java.net.Socket;

/**
 * 创建一个对象
 * 对象的目的是为了包装 用户id + socket用的
 */
public class User {

    private String uid;
    private Socket socket;

    public User(String uid, Socket socket) {
        this.uid = uid;
        this.socket = socket;
    }

    public String getUid() {
        return uid;
    }
    public Socket getSocket() {
        return socket;
    }
}
