package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args){
//        //1.自己通过new创建对象
//        Student student = new Student();
//        //2.自己给属性赋值
//        //  a.通过属性对应的set方法赋值
//        student.setSid(1);
//        student.setSname("zzt");
//        //  b.通过带参数的构造方法赋值
//        new Student(1,"zzt","男",18);

        //将对象的控制权交给别人
        //1.需要创建一个Spring中用来管理bean对象的工厂
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml","ApplicationContext_Controller.xml","ApplicationContext_Service.xml","ApplicationContext_Dao.xml");
//        BeanFactory factory = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml","ApplicationContext_Controller.xml","ApplicationContext_Service.xml","ApplicationContext_Dao.xml"});
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.帮我们创建对象 跟工厂要一个对象
//        System.out.println(factory.getBean("controller"));
//        System.out.println(factory.getBean("service"));
//        System.out.println(factory.getBean("dao"));
        System.out.println(factory.getBean("student1"));
//        System.out.println(factory.getBean("student1"));
    }
}
