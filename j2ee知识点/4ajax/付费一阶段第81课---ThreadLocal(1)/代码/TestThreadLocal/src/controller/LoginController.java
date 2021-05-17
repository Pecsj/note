package controller;

import domain.User;
import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserService service = MySpring.getBean("service.UserService");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理字符集
        request.setCharacterEncoding("UTF-8");
        //获取请求发过来的参数
        String uname = request.getParameter("uname");
        String upassword = request.getParameter("upassword");
        //调用业务层方法做事---原有的
//        String result = service.login(uname,upassword);
//        //根据结果给予响应(通常转发)
//        if(result.equals("登录成功")){
//            //需要将昵称带走   交给welcome进行拼接--展示
//            String nickName = service.getNickName(uname);
//            request.setAttribute("nickName",nickName);
//
//        }else{
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        }


        //如果按照方案二修改原有的service登录方法   返回值类型与平时习惯不一样
        User user = service.login(uname,upassword);
        if(user!=null){
            request.setAttribute("nickName",user.getNickname());
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
