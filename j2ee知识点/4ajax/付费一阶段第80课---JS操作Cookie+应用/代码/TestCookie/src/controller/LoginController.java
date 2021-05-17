package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserService service = new UserService();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理字符集
        request.setCharacterEncoding("UTF-8");
        //接收请求传递的参数
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        //如果参数没有接收到  去cookie找
        if(uname==null && upass==null){
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("uname")){
                    uname = cookie.getValue();
                }
                if(cookie.getName().equals("upass")){
                    upass = cookie.getValue();
                }
            }
        }
        //调用业务方法执行登录判断
        String result = service.login(uname,upass);
        //根据结果转发
        if(result.equals("登录成功")){
            //如果用户勾选了 7日免登录 需要将账号密码存入cookie
            String[] values = request.getParameterValues("flag");
            if(values!=null && values.length>=0){
                Cookie nameCookie = new Cookie("uname",uname);
                Cookie passCookie = new Cookie("upass",upass);
                nameCookie.setMaxAge(20);//设置7天
                passCookie.setMaxAge(20);
                response.addCookie(nameCookie);
                response.addCookie(passCookie);
            }
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
