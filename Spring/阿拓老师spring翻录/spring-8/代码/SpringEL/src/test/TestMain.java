package test;

import domain.Base;
import domain.Computer;
import domain.Person;
import domain.Room;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        //跟Spring的bean工厂要那个room对象
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Room room = (Room)factory.getBean("room");
//        System.out.println(room);
//
//        Person person = (Person)factory.getBean("person");
//        System.out.println(person);

        Computer computer = (Computer)factory.getBean("computer");
        System.out.println(computer);
    }
}
