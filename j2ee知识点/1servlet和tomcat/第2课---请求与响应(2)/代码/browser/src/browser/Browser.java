package browser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Browser {

    private Scanner input = new Scanner(System.in);

    //打开浏览器窗口
    public void openBrowser(){
        //输入一个URL统一资源定位符
        //  ip:port/index.html?key=value&key=value
        //  localhost:9999/controller.IndexController?name=zzt
        //  请求是一个资源名IndexController  反射进行查找
        System.out.print("URL:");
        String url = input.nextLine();
        this.parseURL(url);
    }

    //设计一个方法 解析url
    private void parseURL(String url){
        //找寻冒号和第一个斜杠所在的位置
        int colonIndex = url.indexOf(":");
        int slashIndex = url.indexOf("/");
        //获取IP port contentAndParams
        String ip = url.substring(0,colonIndex);
        int port = Integer.parseInt(url.substring(colonIndex+1,slashIndex));
        String contentAndParams = url.substring(slashIndex+1);
        this.createSocketAndSendRequest(ip,port,contentAndParams);
    }

    //设计一个方法 创建一个socket 将contentAndParams发送给服务器
    private void createSocketAndSendRequest(String ip,int port,String contentAndParams){
        try {
            //通过ip和port创建一个socket
            Socket socket = new Socket(ip,port);
            //将contentAndParams发送出去(给服务器)
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(contentAndParams);//    资源名?key=value&key=value
            out.flush();
            //浏览器等待响应信息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
