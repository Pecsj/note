package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//小护士
public class FilterOne extends HttpFilter {

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是filter 找我干嘛呀");
        //1.直接给予响应  自己拼接字符串
        //response.getWriter().write("<>");
        //2.可以(请求)转发
        //request.getRequestDispatcher("路径").forward(request,response);
        //3.可以(请求)重定向
        //response.sendRedirect("路径");
        //4.可以放行
        chain.doFilter(request,response);
    }
}
