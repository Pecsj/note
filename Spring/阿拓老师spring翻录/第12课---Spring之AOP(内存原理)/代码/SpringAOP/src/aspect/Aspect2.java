package aspect;

/**
 * 这是一个切面对象
 */
public class Aspect2 {

    //切面对象中的分方法本身叫连接点
    //方法什么时候(最终目标之前 之后 。。)执行方式 建议
    public void beforeMethod(){
        System.out.println("Aspect2的后置：喊呀！！！");
    }

    public void afterReturningMethod(){
        System.out.println("Aspect2的后置：非常好");
    }



}
