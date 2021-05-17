package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//        long time = System.currentTimeMillis();
//        System.out.println(time);
//        Date date = new Date(time);
//        System.out.println(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
//        String dateValue = sdf.format(date);
//        System.out.println(dateValue);

        Date date = new Date();
        request.setAttribute("date",date);


        String strValue = "abcdefg";
        request.setAttribute("strValue",strValue);


        String str = "a-b-c-d-e-f";
        request.setAttribute("str",str);

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
