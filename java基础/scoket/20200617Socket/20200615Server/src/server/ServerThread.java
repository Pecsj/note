package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * 这个类是服务端新写的一个线程类
 * 这是服务器真正该做的事情
 * 先读取某一个客户端发来的消息
 * 而后转发给某一个人(单聊)、某一些人(群聊)
 */
public class ServerThread extends Thread{

    private User user;
    public ServerThread(User user){
        this.user = user;
    }

    public void run() {
        try {
            Map<String,User> userBox = Server.userBox;
            //1.先读取客户端消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(user.getSocket().getInputStream()));

            while(true) {
                //读取到用户发来的消息
                //message@name@name
                //  2020-06-17 21:35:00####zzt:大家听懂了么
                String message = reader.readLine();
                //在这里将客户端发来的消息保存一下  数据库里  uid time message targetUid

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
                String time = sdf.format(date);

                System.out.println(time+"####"+user.getUid()+":"+message);
                //2.转发  一个 map.get(uid) 好多 遍历map  拼接uid 拼接时间
                //解析一下message   看是否有@某一个人
                //  你好么
                //  String[] {"你好么","博哥","Andy"}
                String[] valueAndUser = message.split("@");
                if (valueAndUser.length == 1) {//群聊
                    //将服务端的map集合遍历一遍
                    Iterator<String> it = userBox.keySet().iterator();
                    while (it.hasNext()) {
                        String uid = it.next();
                        User u = userBox.get(uid);//map集合中的其他人(也包括当前发送的那个user)
                        Socket socket = u.getSocket();
                        PrintWriter writer = new PrintWriter(socket.getOutputStream());
                        writer.println(time+"####"+user.getUid() + ":" + message);
                        writer.flush();
                    }
                } else {//单聊  严谨的判断 用户是否存在
                    //valueAndUser[0]   valueAndUser[1] valueAndUser[2]
                    for (int i = 1; i < valueAndUser.length; i++) {//单聊时候找到所有被@的人
                        String name = valueAndUser[i];
                        User u = userBox.get(name);//map集合中的其他人(通过@解析寻找的)
                        Socket socket = u.getSocket();
                        PrintWriter writer = new PrintWriter(socket.getOutputStream());
                        writer.println(time+"####"+user.getUid() + ":" + valueAndUser[0]);
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(user.getUid()+"下线啦");
        }
    }
}
