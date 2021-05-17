package client;

import java.io.*;
import java.net.Socket;

/**
 * 自己模拟的客户端
 */
public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("==client start==");
            //1.主动发起访问  服务器在哪儿? IP  服务器开放的端口多少?  port
            Socket socket = new Socket("localhost",9999);
            //需要通过socket将自己的id (pass)写给服务端
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("andy");
            writer.flush();

            //启动两个线程小弟 让他们帮我做事
            ClientReader cr = new ClientReader(socket);
            ClientWriter cw = new ClientWriter(socket);
            cr.start();
            cw.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
