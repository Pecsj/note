package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是真实的目标对象  取值 调用业务 转发");

        //服务器内部的请求转发   请求重定向
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
        //response.sendRedirect("welcome.jsp");
    }
}
