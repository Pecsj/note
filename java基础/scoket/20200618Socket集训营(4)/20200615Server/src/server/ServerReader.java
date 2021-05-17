package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReader extends Thread {

    private Socket socket;
    public ServerReader(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            //服务端读取客户端回写的消息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while(true){
                String value = reader.readLine();
                System.out.println(value);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("一个客户端下线了");
        }
    }
}
