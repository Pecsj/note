package filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(
        urlPatterns={"/*"},
        initParams={
                @WebInitParam(name="key1",value="value1"),
                @WebInitParam(name="key2",value="value2")
        }
)
public class TestFilter extends HttpFilter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是filter，我加载啦");
        Enumeration en = filterConfig.getInitParameterNames();
        while(en.hasMoreElements()){
            String key = (String)en.nextElement();
            String value = filterConfig.getInitParameter(key);
            System.out.println(key+"----"+value);
        }
    }

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是filter，我执行啦");
        chain.doFilter(request,response);
    }
}
