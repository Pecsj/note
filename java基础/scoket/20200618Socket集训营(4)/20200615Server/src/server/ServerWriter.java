package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerWriter extends Thread {

    private Socket socket;
    public ServerWriter(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            Scanner input = new Scanner(System.in);
            //服务端发送数据  通过socket创建输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            //为了发送数据的时候可以发送中文  字节流包装成字符流
            while(true) {
                String message = input.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
