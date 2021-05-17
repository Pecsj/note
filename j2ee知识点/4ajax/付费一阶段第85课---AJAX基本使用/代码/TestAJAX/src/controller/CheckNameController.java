package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkName")
public class CheckNameController extends HttpServlet {

    private UserService servive = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求发送过来的名字
        String uname = request.getParameter("uname");
        //找寻一个业务方法 负责检测名字是否存在
        String result = servive.checkName(uname);
        //根据业务的结果给予响应
        //  1.直接给响应  response.getWriter()   write("");
        //  2.转发        JSP(本身就是拼接响应  内容就是响应信息)
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(result);//JSON
    }
}
