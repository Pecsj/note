package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.StudentService;

/**
 * 控制层
 *      1.继承父类  2.重写方法  3.参数  返回值  异常。。。。
 *      封装-----没有继承  方法随便   参数随便(IOC DI)  返回值(void String ModelAndView)  没有异常
 *
 *      控制层方法做的事情
 *      1.接收请求参数信息
 *      2.调用业务层的小弟支持我
 *      3.根据业务层执行  最终控制响应信息
 */

@Controller("studentController")
public class StudentController {

    //属性  业务层小弟
    private StudentService service;
    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    //自己控制方法
    public void contollerMethod(String ssex){
        System.out.println("controllerMethod");
        service.serviceMethod(ssex);
    }
}
