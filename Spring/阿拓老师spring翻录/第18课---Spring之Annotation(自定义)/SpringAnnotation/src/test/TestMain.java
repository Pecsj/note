package test;

import com.sun.javaws.Main;
import configclass.ConfigClass;
import configclass.MainConfig;
import controller.StudentController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    public static void main(String[] args) {
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        StudentController controller = (StudentController) factory.getBean("studentController");
//        controller.contollerMethod("男");


//        Student student1 = (Student)factory.getBean("student");
//        Student student2 = (Student)factory.getBean("student");
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student1==student2);


//        StudentController controller = (StudentController)factory.getBean("studentController");
//        System.out.println(controller);
//        System.out.println(controller.getService());


//        Student student = (Student)factory.getBean("student");
//        System.out.println(student);
//        System.out.println(student.getTestInterface());
//        System.out.println(student.getSid()+"--"+student.getSname()+"--"+student.getSsex()+"--"+student.getSage());


        //通过扫描注解的方式获取一个工厂对象 改变创建工厂的类
        BeanFactory factory = new AnnotationConfigApplicationContext(MainConfig.class);
        StudentController controller = (StudentController) factory.getBean("studentController");
        controller.contollerMethod("男");

    }
}
