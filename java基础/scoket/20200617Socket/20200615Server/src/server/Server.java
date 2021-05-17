package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 自己设计的服务端
 */
public class Server {

    //服务端应该有一个map集合
    //存储好多个用户的
    static Map<String,User> userBox = new HashMap();

    public static void main(String[] args) {
        try {

            //1.创建一个服务端对象
            //      抽象类 接口
            //      构造方法没有无参数
            //      编译时异常
            System.out.println("==server start==");
            ServerSocket server = new ServerSocket(9999);
            while(true){
                //2.等待客户端连接我  并且同意/接收
                Socket socket = server.accept();
                //读取客户端传递过来的id号
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String uid = reader.readLine();
                //有没有登录业务---多一个判断 成功再存
                //如果没有登录业务---存入集合
                User user = new User(uid,socket);
                Server.userBox.put(uid,user);
                System.out.println(uid+"上线啦");
                //开启一个服务器线程 负责当前这个客户端的读写操作
                ServerThread st = new ServerThread(user);
                st.start();

                //需要开启两个线程对象 分别负责当前客户端对应的读写操作
//                ServerReader sr = new ServerReader(socket);
//                ServerWriter sw = new ServerWriter(socket);
//                sr.start();
//                sw.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
