package client;

import javax.swing.*;
import java.awt.*;

public class QQFrame extends JFrame {

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
    public QQFrame(){
        this.setOther();
        this.addElements();
        this.addListener();
        this.setFrameSelf();
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

    public static void main(String[] args) {
        new QQFrame();
    }
}
