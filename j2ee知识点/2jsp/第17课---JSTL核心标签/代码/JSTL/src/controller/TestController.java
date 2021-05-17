package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TestController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int day = 1;
        request.setAttribute("day",day);

        int value = 10;
        request.setAttribute("value",value);

        User user = new User("zzt","123");
        request.setAttribute("user",user);

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("zhangsan","333"));
        userList.add(new User("lisi","444"));
        userList.add(new User("wangwu","555"));
        request.setAttribute("userList",userList);



        request.getRequestDispatcher("show.jsp").forward(request,resp);
    }
}
