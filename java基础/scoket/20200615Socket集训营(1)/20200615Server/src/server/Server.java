package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 自己设计的服务端
 */
public class Server {

    //服务端应该有一个map集合
    //存储好多个用户的
    private static Map<String,User> userBox = new HashMap();

    public static void main(String[] args) {
        try {

            //1.创建一个服务端对象
            //      抽象类 接口
            //      构造方法没有无参数
            //      编译时异常
            System.out.println("==server start==");
            ServerSocket server = new ServerSocket(9999);
            while(true) {
                //2.等待客户端连接我  并且同意/接收
                Socket socket = server.accept();
                System.out.println(socket);
                System.out.println("有一个客户端连接我啦");
                //读取客户端传递过来的id号
                //有没有登录业务---多一个判断 成功再存
                //如果没有登录业务---存入集合
//                Server.userBox.put(id,user(id,socket));
            }
            //======================================
//            while(true) {
//                System.out.println("跟客户端说点什么吧");
//                Scanner input = new Scanner(System.in);
//                String message = input.nextLine();
//                //服务端发送数据  通过socket创建输出流
//                OutputStream os = socket.getOutputStream();
//                //为了发送数据的时候可以发送中文  字节流包装成字符流
//                PrintWriter writer = new PrintWriter(os);
//                writer.println(message);
//                writer.flush();
//
//                //服务端读取客户端回写的消息
//                InputStream is = socket.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader reader = new BufferedReader(isr);
//                String value = reader.readLine();
//                System.out.println(value);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
