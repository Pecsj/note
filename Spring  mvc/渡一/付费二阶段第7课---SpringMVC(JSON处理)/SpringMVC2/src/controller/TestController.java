package controller;

import domain.Student;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(path="testOne.do",params={"user=zzt","pass"})
    public void testOne(){
        System.out.println("testOne");
    }

    @RequestMapping(value="testTwo.do",method=RequestMethod.POST)
    public void testTwo(){
        System.out.println("testTwo");
    }

    @RequestMapping(path="testThree.do",headers={"Accept-Language"})
    public void testThree(){
        System.out.println("testThree");
        //1.接收请求发来的参数
        //2.调用service业务层做逻辑处理
        //3.service得到的结果  响应处理
    }

    //=======================================================================

    //浏览器发送请求   xxx.do
    //先参考web.xml文件   拦截 *.do
    //找到一个"小总管"DispatcherServlet
    //"小总管"参考自己的文件   ApplicationContext.xml  (告知需要扫描注解)
    //根据注解和方法的对应关系找到下面这个方法
    //  找方法的过程---反射技术
    //  "小总管"将我们的方法参数处理了一下  IOC+DI
    //      反射创建对象
    //      处理字符集(POST)
    //      String value = request.getParameter("key");
    //      解析对象中的每个属性类型
    //      String---属性类型
    //      类型的转换问题(基本类型底层都处理了 Date不太一样)   自定义类型转换器
    //      值存入对象属性内
    //  找到方法的目的是执行方法  invoke(obj,参数)

    @RequestMapping("testParam1.do")
    public String testParam1(@RequestBody String body, @CookieValue("JSESSIONID") String cookieValue, @RequestHeader("Accept-Language")String header){
        //请求(参数)  domain  控制层  业务层  持久层  domain(属性-数据库中列)  JDBC-->数据库
        System.out.println("参数的测试方法");
//        System.out.println("接收到的参数:"+user);
        System.out.println("接收到的body:"+body);
        System.out.println("接收到的header:"+header);
        System.out.println("接收到的cookie:"+cookieValue);
        return "welcome.jsp";
    }

    //===========================================================================
    //测试响应信息
    @RequestMapping("login.do")
    public String testResponse(String username,String password){
        System.out.println("假如这是一个用来控制登录的方法");
        System.out.println(username+"--"+password);

        //Model  ModelMap  ModelAndView
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","value");
        mv.setViewName("welcome.jsp");
        //理论上应该去调用一个业务层的方法
        //String result = service.login(username,password);
        //通常业务层处理完毕后 的结果可能会存储起来 带走
        //request.setAttribute("key",value);
        //session.setAttribute("key",value);
        //return "forward:welcome.jsp";
//        return "redircet:welcome.jsp";
        return "welcome.jsp";
        // "" --> index.jsp
        // "null" -->  null  404
        // null  -->  login  404

//        try {
//            //0.设置响应的字符集
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html;charset=UTF-8");
//            //1.获取response对象(参数)
//            //2.获取PrintWriter输出流
//            PrintWriter writer = response.getWriter();
//            writer.write("你好");
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            request.getRequestDispatcher("welcome.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            response.sendRedirect("welcome.jsp");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    //====================================================================
    //设计一个方法 用来测试异步请求
    @ResponseBody
    @RequestMapping("testAJAX.do")
    public String testAJAX(@RequestBody Student student){
        System.out.println("这是testAJAX方法:"+student);
        //调用业务层处理逻辑  Student student = service.xxx(sid);
        //业务层处理逻辑后 通常会获得结果
        //  String/int/float  domain/map  List<domain>  Map<String,domain>
        //  1.带着这些结果 走掉(转发Controller JSP)
        //      request.setAttribute("key",object);
        //      session.setAttribute("key",object);
        //  2.直接讲这些数据响应给浏览器(发送是一个异步请求 浏览器展示静态数据一半了 需要我们这个数据进行拼接)
        //      response.getWriter().write(对象--JSON);

        //将对象转化为JSON直接响应
        //Student result = new Student(1,"zzt","男");
        //return result;

//        Map map = new HashMap();
//        map.put("sid",1);
//        map.put("sname","zzt");
//        return map;

//        List list = new ArrayList();
//        list.add(new Student(1,"zzt1","男"));
//        list.add(new Student(2,"zzt2","男"));
//        list.add(new Student(3,"zzt3","男"));
//        return list;

        String result = "hehe";
        return result;
        //1.想要让框架帮我们转化 框架本身没有外部jar包 需要导包json   jackson(core databind annotations)
        //2.返回值原来只有void和String 现在这个类型框架不认识 告知框架这个返回值类型需要帮我们处理
    }

}
