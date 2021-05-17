package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 这是一个切面对象
 */
public class Aspect1 {

    //切面对象中的分方法本身叫连接点
    //方法什么时候(最终目标之前 之后 。。)执行方式 建议
    public void beforeMethod(){
        System.out.println("预备 开始 喊~~~");
    }

    public void afterReturningMethod(){
        System.out.println("请坐");
    }

    public void afterThrowingMethod(){
        System.out.println("出现异常啦");
    }

    public void afterMethod(){
        System.out.println("最终我很开心");
    }

    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {//特别像是以前的Filter  放行  底层责任链实现方式
        System.out.println("环绕建议前部分");
        //中间等待目标执行完
        pjp.proceed();//chain.doFilter();
        System.out.println("环绕建议后部分");
    }

}
