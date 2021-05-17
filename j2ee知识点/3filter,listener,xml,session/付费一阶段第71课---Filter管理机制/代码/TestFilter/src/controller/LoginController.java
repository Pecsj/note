package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//目标
public class LoginController extends HttpServlet {

    private AtmService service = new AtmService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.获取请求参数
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        //2.调用业务方法干活儿
        String result = service.login(aname,apassword);
        //3.给予响应    转发
        if(result.equals("登录成功")) {
            //将人名存储在session作用域内啦
            HttpSession session = request.getSession();
            session.setAttribute("aname",aname);
            session.setMaxInactiveInterval(8);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }else {
            request.setAttribute("result",result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
