package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//目标
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是loginController");
        //1.获取请求参数
        //2.调用业务方法干活儿
        //3.给予响应    转发
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
    }
}
