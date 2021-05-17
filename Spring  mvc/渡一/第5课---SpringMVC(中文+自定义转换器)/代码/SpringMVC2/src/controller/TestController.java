package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

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

    @ModelAttribute("testParam1.do")
    public void xxx(){

    }

}
