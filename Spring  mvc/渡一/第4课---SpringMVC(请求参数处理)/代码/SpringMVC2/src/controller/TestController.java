package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @RequestMapping("testParam1.do")
    public String testParam1(User user){
        //请求(参数)  domain  控制层  业务层  持久层  domain(属性-数据库中列)  JDBC-->数据库
        System.out.println("参数的测试方法");
        System.out.println("接收到的参数:"+user);
        return "welcome.jsp";
    }

}
