package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *  客户端的写线程
 *  帮助客户端进行写操作
 */
public class ClientWriter extends Thread {

    private Socket socket;
    public ClientWriter(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            //客户端回写数据
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
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
