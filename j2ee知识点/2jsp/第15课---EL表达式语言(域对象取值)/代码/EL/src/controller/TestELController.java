package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestELController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String str = "TestStringValue";
        request.setAttribute("str",str);
        //上述存储 可以基本数据类型 基本类型对应的包装类类型 String

        User user = new User("zhangsan","333");
        request.setAttribute("user",user);
        //上述存储 可以将某一个domain或其他类型的对象进行处理
        //在JSP中可以使用${requestScope.user.属性名/属性对应的get方法}

        //数组[基本、对象] 集合List Set Map
        //参数 配置context-param
        //简单的计算 算数 逻辑 比较 ${取值 计算}

        request.getRequestDispatcher("showELValue.jsp").forward(request,resp);
    }
}
