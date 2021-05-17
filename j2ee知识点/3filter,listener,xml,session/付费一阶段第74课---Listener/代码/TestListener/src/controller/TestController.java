package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test = request.getParameter("test");
        System.out.println("我是controller---->"+test);

        //存值
        request.setAttribute("test",test);
        //修改
        request.setAttribute("test","hahaha");
        //删除
        request.removeAttribute("test");

        HttpSession session = request.getSession();
        session.setAttribute("test",test);
        session.setAttribute("test","hehehe");
        session.removeAttribute("test");
        //session.setMaxInactiveInterval(2);//对象销毁了么？ 只是不活跃
        session.invalidate();//让session对象销毁啦

    }
}
