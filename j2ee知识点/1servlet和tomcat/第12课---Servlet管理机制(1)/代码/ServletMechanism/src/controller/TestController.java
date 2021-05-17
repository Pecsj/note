package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestController extends HttpServlet {

    //Servlet对象创建的时候调用的   像是构造方法
    public void init(){
        System.out.println("controller被创建啦");
    }
    //Servlet对象被回收的时候调用的  像是finalize方法
    public void destroy(){
        System.out.println("controller被回收啦");
    }

    //私有构造方法
    //私有静态当前类对象作为属性
    //公有静态的方法将属性对象返回

    //添加一个属性 用来测试
    private int count = 1;

    //每一次发送请求 都执行一次
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("我是控制层的方法 点我干嘛呀???"+ count++ );
    }
}
