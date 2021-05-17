package exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个自定义的异常处理类
 * 原来的小总管不会帮我们处理
 * 我们自己写类  自己定义处理规则
 * 将这个类交个Spring管理
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //1.验证一下捕获的异常是不是刚才我们抛出的那个
        if(e instanceof MyException){
            //2.证明Controller以及后面的处理确实产生了问题
            //  但是还不想让用户看到
            ModelAndView mv = new ModelAndView();
            mv.addObject("errorMessage",e.getMessage());
            mv.setViewName("error.jsp");
            return mv;
        }
        return null;
    }
}
