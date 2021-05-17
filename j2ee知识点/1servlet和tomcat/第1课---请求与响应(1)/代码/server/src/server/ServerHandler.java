package server;

import java.net.Socket;

public class ServerHandler extends Thread {

    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        this.receiveRequest();
    }
    //读取消息
    private void receiveRequest(){

    }
    //解析
    private void parseContentAndParams(){

    }
    //找人干活---控制层
    private void findController(){

    }
    //将最终的响应信息 写回浏览器
    private void responseToBrowser(){

    }

}
