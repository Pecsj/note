package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 自己模拟的客户端
 */
public class Client {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("==client start==");
            //1.主动发起访问  服务器在哪儿? IP  服务器开放的端口多少?  port
            Socket socket = new Socket("localhost",9999);
            //需要通过socket将自己的id (pass)写给服务端

            //=====================================================
//            while(true) {
//                //客户端 接收发来的数据
//                InputStream is = socket.getInputStream();
//                //将字节流转化成字符流
//                InputStreamReader isr = new InputStreamReader(is);
//                //字符流基础上 可以读取一行
//                BufferedReader reader = new BufferedReader(isr);
//                String value = reader.readLine();
//                System.out.println(value);
//
//                //客户端回写数据
//                System.out.println("跟服务端回写点什么吧");
//                String message = input.nextLine();
//                OutputStream os = socket.getOutputStream();
//                PrintWriter writer = new PrintWriter(os);
//                writer.println(message);
//                writer.flush();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
