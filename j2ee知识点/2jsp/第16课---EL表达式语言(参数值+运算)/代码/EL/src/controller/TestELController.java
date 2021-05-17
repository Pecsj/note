package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TestELController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int value = 10;
        request.setAttribute("value",value);
        String strValue = "10";
        request.setAttribute("strValue",strValue);

        String str = "TestStringValue";
        request.setAttribute("str",str);
        //上述存储 可以基本数据类型 基本类型对应的包装类类型 String

        User user = new User("zhangsan","333");
        request.setAttribute("user",user);
        //上述存储 可以将某一个domain或其他类型的对象进行处理
        //在JSP中可以使用${requestScope.user.属性名/属性对应的get方法}

        int[] intArray = new int[]{10,20,30};
        request.getSession().setAttribute("intArray",intArray);
        User[] userArray = {new User("zhangsan","333"),new User("lisi","444")};
        request.setAttribute("userArray",userArray);
        String[][] strDoubleArray = {{"aa","bb"},{"cc","dd","ee"}};
        request.setAttribute("strDoubleArray",strDoubleArray);
        //上述存储数组[基本、对象]
        //  通过${xxxScope.数组名[index]}    如果index越界则不予展示

        ArrayList<Float> floatList = new ArrayList<Float>();
        floatList.add(3.4F);floatList.add(4.5F);floatList.add(5.6F);
        request.setAttribute("floatList",floatList);
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("zhangsan","333"));userList.add(new User("lisi","444"));
        request.setAttribute("userList",userList);
        // 上述List集合
        //  通过${xxxScope.集合名.get(index)}    如果index越界则会产生异常

        HashSet<User> userSet = new HashSet<User>();
        userSet.add(new User("zhangsan","333"));
        userSet.add(new User("lisi","444"));
        request.setAttribute("userSet",userSet);
        //上述是Set集合
        // 可以获取集合对象 可以获取size 但不能通过get()方法获取set集合中的内容 需要JSTL

        HashMap<String,String> strMap = new HashMap<String,String>();
        strMap.put("aaa","aaa");strMap.put("bbb","bbb");
        request.setAttribute("strMap",strMap);
        //上述是Map集合
        //  ${xxxScope.集合名.get(key).属性}     如果key不存在则不展示
        //参数 配置context-param
        //简单的计算 算数 逻辑 比较 ${取值 计算}

        request.getRequestDispatcher("showELValue.jsp").forward(request,resp);
    }
}
