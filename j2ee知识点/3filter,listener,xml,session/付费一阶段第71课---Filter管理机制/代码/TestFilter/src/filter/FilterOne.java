package filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

//小护士
public class FilterOne extends HttpFilter {

    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration en = filterConfig.getInitParameterNames();
        while(en.hasMoreElements()){
            String key = (String)en.nextElement();
            String value = filterConfig.getInitParameter(key);
            System.out.println(key+"--"+value);
        }
    }

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是filter 找我干嘛呀");

        HttpSession session = request.getSession();
        String aname = (String)session.getAttribute("aname");

        String uri = request.getRequestURI();//获取请求路径
        //先判断大前提  请求的时候 是否包含index login
        if(uri.contains("index") || uri.contains("login")){
            //放行 此时还没有真正做登录判断
            chain.doFilter(request,response);
        }else{
            //应该是登录成功之后的某一个功能
            if(aname!=null){
                chain.doFilter(request,response);
            }else{
                request.setAttribute("result","登录已超时，请重新登录");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }

        //1.直接给予响应  自己拼接字符串
        //response.getWriter().write("<>");
        //2.可以(请求)转发
        //request.getRequestDispatcher("路径").forward(request,response);
        //3.可以(请求)重定向
        //response.sendRedirect("路径");
        //4.可以放行
        //chain.doFilter(request,response);
    }
}
