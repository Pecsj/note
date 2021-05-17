package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestCookieController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第二次请求到达服务器
        //服务器中的一个Controller类资源中进行cookie信息的操作
        String param = request.getParameter("param");
        System.out.println("参数:"+param);
        //获取cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+"-------"+value);
        }
        //服务器给予响应
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
    }
}
