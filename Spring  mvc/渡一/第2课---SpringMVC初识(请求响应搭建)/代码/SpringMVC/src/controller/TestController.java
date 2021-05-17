package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个控制层的类
 * 这个类最早用Tomcat管理的时候
 * 是有一些规则的
 * 1.继承                             实现Controller
 * 2.重写                             重写handleRequest
 * 3.参数 request response            两个参数
 * 4.返回值                           返回值ModelAndView
 * 5.异常等等                          异常
 *
 * 请求--真实资源的对应关系
 *      配置文件  SpringMVC自己的文件
 *
 *
 * 可以将原有xml形式改为注解形式
 * @Controller------->为了替代原有xml中的<bean><bean/>(Spring做的事，Spring注重对象管理)
 * 只是告知Spring容器，有一个Controller类对象需要交由你来管理，放在spring底层map容器里
 * @RequestMapping--->说明请求名字和一个真实类名字对应关系(MVC该做的事，SpringMVC注重的是请求和响应)
 */

@Controller
@RequestMapping("TestController.do")
public class TestController {

    @RequestMapping
    public String test(){
        System.out.println("我是基于注解的controller，我执行啦，这多开心");
        return "welcome.jsp";
    }


//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        System.out.println("我是controller，我执行啦");
//        return null;
//    }
}
