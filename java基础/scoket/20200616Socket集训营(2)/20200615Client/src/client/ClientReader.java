package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 这是一个新的类
 * 这个类的对象  负责帮助客户端进行读操作
 * 这个类需要变成线程
 */
public class ClientReader extends Thread {

    private Socket socket;
    public ClientReader(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            //客户端 接收发来的数据
            InputStream is = socket.getInputStream();
            //将字节流转化成字符流
            InputStreamReader isr = new InputStreamReader(is);
            //字符流基础上 可以读取一行
            BufferedReader reader = new BufferedReader(isr);
            while(true) {
                String value = reader.readLine();
                System.out.println(value);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("服务器宕机了");
        }
    }

}
