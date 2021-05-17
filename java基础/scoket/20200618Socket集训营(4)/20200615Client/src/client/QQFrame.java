package client;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class QQFrame extends JFrame {

    //添加一个属性---表示QQ窗口的名字
    private String uid;
    //添加一个属性---表示客户端连接的socket对象
    private Socket socket;

    private JPanel panel = new JPanel();//无色透明的小容器 小盒子
    //2.有一些组件
    //  文本域(接收信息并展示的 上面部分)
    private JTextArea messArea = new JTextArea();
    private JScrollPane messPane = new JScrollPane(messArea);
    //  文本域(发送信息的 下面部分)
    private JTextArea speakArea = new JTextArea();
    private JScrollPane speakPane = new JScrollPane(speakArea);
    //  按钮(发送)
    private JButton sendButton = new JButton("发送");
    //  按钮(取消)
    private JButton cancelButton = new JButton("取消");

    //构造方法(规定调用的流程)
    public QQFrame(String uid){
        super(uid);
        //加载窗口的组件
        this.setOther();
        this.addElements();
        this.addListener();
        this.setFrameSelf();
        //窗口相当于是一个客户端 产生一个客户端连接
        try {
            socket = new Socket("localhost",9999);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(uid);
            writer.flush();
            //只需要一个小弟来为我们做事------客户端读线程
            ClientReader cr = new ClientReader(socket);
            cr.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法 设置那些乱七八糟的东西
    private void setOther(){
        //设置组件的位置
        //将默认布局清空
        panel.setLayout(null);
        //将所有的组件自定义放在panel中
        messPane.setBounds(10,10,320,220);
        speakPane.setBounds(10,240,320,140);
        sendButton.setBounds(180,390,60,30);
        cancelButton.setBounds(260,390,60,30);
        //设置一下上面展示的文本域不允许修改了
        messArea.setEditable(false);
        messArea.setFont(new Font("宋体",Font.BOLD,18));
        speakArea.setFont(new Font("宋体",Font.BOLD,18));
    }

    //设计一个方法 添加组件
    private void addElements(){
        //将这些组件放置在窗体里
        panel.add(messPane);
        panel.add(speakPane);
        panel.add(sendButton);
        panel.add(cancelButton);
        this.add(panel);
    }

    //设计一个方法 给组件添加事件(功能)
    private void addListener(){
        //取消按钮绑定一个功能
        cancelButton.addActionListener(e -> {
            speakArea.setText("");
        });

        //给发送按钮绑定一个功能
        sendButton.addActionListener(e -> {
            try {
                OutputStream os = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(os);
                String message = speakArea.getText();
                writer.println(message);
                writer.flush();
                //发送完毕之后，让发送的说话框清空
                speakArea.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    //设计一个方法 设置窗体自身的一些元素
    private void setFrameSelf(){
        //2.设置窗体一些样式
        this.setResizable(false);
        //设置窗体点击右上角X 程序结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体的初始位置
        this.setBounds(500,200,350,480);
        //让窗体可见
        this.setVisible(true);
    }

    //=======================================================================

    /**
     * 内部类
     *
     * 这是一个新的类
     * 这个类的对象  负责帮助客户端进行读操作
     * 这个类需要变成线程
     */
    private class ClientReader extends Thread {

        private Socket socket;
        public ClientReader(Socket socket){
            this.socket = socket;
        }

        public void run(){
            StringBuilder result = new StringBuilder();
            try {
                //客户端 接收发来的数据
                InputStream is = socket.getInputStream();
                //将字节流转化成字符流
                InputStreamReader isr = new InputStreamReader(is);
                //字符流基础上 可以读取一行
                BufferedReader reader = new BufferedReader(isr);
                while(true) {
                    //每次读取一行数据
                    String value = reader.readLine();
                    //一行数据进行处理  换行
                    value = value.replace("####","\r\n");
                    //追加到StringBuilder对象中   频繁拼接效果更好
                    result.append(value);
                    result.append("\n");
                    //展示在上面的文本域中
                    messArea.setText(result.toString());
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("服务器宕机了");
            }
        }
    }

}
