package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 这是一个切面对象
 */
public class Aspect1 {

    //切面对象中的分方法本身叫连接点
    //方法什么时候(最终目标之前 之后 。。)执行方式 建议
    public void beforeMethod(){
        System.out.println("Aspect1的前置：预备 开始 喊~~~");
    }

    public void afterReturningMethod(){
        System.out.println("Aspect1的后置：请坐");
    }

    //环绕通知、环绕建议(执行与之前的Filter是一致 需要等待别人执行完 自己再释放)
    public void aroundMethod(ProceedingJoinPoint pjp){//public void doFilter(FilterChain chain){
        System.out.println("Aspect1的环绕前：");
        try {
            pjp.proceed();//chain.doFilter(request,response);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Aspect1的环绕后：");
    }



//    public void afterThrowingMethod(){
//        System.out.println("出现异常啦");
//    }
//
//    public void afterMethod(){
//        System.out.println("最终我很开心");
//    }
//
//    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {//特别像是以前的Filter  放行  底层责任链实现方式
//        System.out.println("环绕建议前部分");
//        //中间等待目标执行完
//        pjp.proceed();//chain.doFilter();
//        System.out.println("环绕建议后部分");
//    }

}
