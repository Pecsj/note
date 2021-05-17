package server;

/**
 * 这个类是服务端新写的一个线程类
 * 这是服务器真正该做的事情
 * 先读取某一个客户端发来的消息
 * 而后转发给某一个人(单聊)、某一些人(群聊)
 */
public class ServerThread extends Thread{

    public void run() {
        while (true){
            //1.先读取客户端消息
            //2.转发  一个 map.get(uid) 好多 遍历map  拼接uid 拼接时间
        }
    }
}
