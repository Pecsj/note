package test;

import controller.TestController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        //调用controller中的那个test方法
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //1.需要一个controller对象---->IOC管理对象
        TestController controller = (TestController)factory.getBean("controller");
        //2.对象.调用就开业啦
        controller.test();//目标方法













        /*
                try{
                    前置
                    环绕前
                    目标方法(环绕的是目标的前后)
                    环绕后
                    后置
                }catch(){
                    异常
                }finally{
                    最终
                }
         */
    }
}
