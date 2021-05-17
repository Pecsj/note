package test;

import controller.StudentController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        StudentController controller = (StudentController) factory.getBean("studentController");
        controller.contollerMethod("男");
    }
}
