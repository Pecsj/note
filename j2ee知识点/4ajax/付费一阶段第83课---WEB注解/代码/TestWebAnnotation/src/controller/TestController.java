package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(
//        name = "",
//        description = "",
//        displayName = "",
//        asyncSupported = true,
//        value="",
        urlPatterns={"/test",""},
        loadOnStartup=0,
        initParams={
                @WebInitParam(name="zhangsan",value="333"),
                @WebInitParam(name="lisi",value="444"),
                @WebInitParam(name="wangwu",value="555")
        }
)
public class TestController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("testController对象加载了");
        Enumeration en = config.getInitParameterNames();//获取全部参数的key
        while(en.hasMoreElements()){
            String key = (String)en.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key+"---"+value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是testController，我执行啦");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name+"--"+pass);
    }
}
