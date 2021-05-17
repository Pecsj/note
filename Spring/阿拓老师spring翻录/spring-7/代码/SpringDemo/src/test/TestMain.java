package test;

import controller.StudentController;
import domain.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testinterface.TestInterface;
import testinterface.TestService;

import java.util.*;

public class TestMain {

    public static void main(String[] args){
//        //1.自己通过new创建对象
//        Student student = new Student();
//        //2.自己给属性赋值
//        //  a.通过属性对应的set方法赋值
//        student.setSid(1);
//        student.setSname("<zzt~>");
//        //  b.通过带参数的构造方法赋值
//        new Student(1,"zzt","男",18);

        //将对象的控制权交给别人
        //1.需要创建一个Spring中用来管理bean对象的工厂
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml","ApplicationContext_Controller.xml","ApplicationContext_Service.xml","ApplicationContext_Dao.xml");
//        BeanFactory factory = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml","ApplicationContext_Controller.xml","ApplicationContext_Service.xml","ApplicationContext_Dao.xml"});
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        BeanFactory factory2 = new FileSystemXmlApplicationContext("");


        //2.帮我们创建对象 跟工厂要一个对象
//        System.out.println(factory.getBean("controller"));
//        System.out.println(factory.getBean("service"));
//        System.out.println(factory.getBean("dao"));
//        System.out.println(factory.getBean("student1"));
//        System.out.println(factory.getBean("student1"));

        //======================================================================================
        //演示Spring的DI
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Student student = (Student)factory.getBean("student");
        //getBean底层
        //  1.读取xml文件----> class(domain.Student)
        //  2.Class clazz = Class.forName("domain.Student");
        //  3.Student student = (Student)clazz.newInstance();
        //  4.找寻class中所有的私有属性
        //      Filed[] fs = clazz.getFields();
        //      for(fs){
        //          属性类型 getType
        //          属性名字 getName
        //          处理set方法名字  set+大写+属性名后半部分
        //          Method m = clazz.getMethod();
        //          set.invode();
        //      }

        //  构造方法的方式
        //  1.创建bean工厂  读取XML文件  class类名字
        //  2.Class clazz = Class.forName(类名字);
        //  3.找到带参数的构造方法
        //      Constructor con = clazz.getConstructor(配置决定参数个数);
        //      配置还决定是否能与属性名匹配
        //      反射找到那个属性  属性类型
        //  4.执行构造方法创建对象
        //      con.newInstance(值);
//        System.out.println(student);


        //==========================================================================

//        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student)factory.getBean("student");
//        String sname = student.getSname();//sname="null"  sname=null
//        System.out.println(sname.length());//4  NullPointerException
//        System.out.println(student.getSage().toString());
//        System.out.println(student);


//        Room room = (Room)factory.getBean("room");
//        System.out.println(room);
//        Computer computer = room.getComputer();
//        System.out.println(computer);

//        Room room = new Room();
//        room.setName("001");
//        room.setComputer(new Computer());//此时电脑内部的属性是没有值
//        room.getComputer().setBrand("联想");

        //当前这个电脑对象 应该是room中的属性对象



//        StudentController controller = (StudentController) factory.getBean("controller");
//        controller.login();//接收请求参数 调用service处理业务(需要调用dao方法支持) 给予响应


//        TestService ts = (TestService)factory.getBean("testService");
//        TestInterface ti = ts.getTi();//接口-->ImplA对象
//        ti.interfaceMethod();


        //============================================================================
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        TestBean testBean = (TestBean)factory.getBean("testBean");
//        System.out.println(testBean.getName());
//        System.out.println(testBean.getAge());

//        Computer[] computers = testBean.getComputers();
//        for(Computer v:computers){
//            System.out.println(v);
//        }

//        List<Computer> list = testBean.getList();
//        System.out.println(list);


//        String name = testBean.getName();
//        System.out.println(name);
//        Computer computer = testBean.getComputer();
//        System.out.println(computer);
//        Set<Computer> set = testBean.getSet();//无序 无重复
//        Iterator<Computer> it = set.iterator();
//        while(it.hasNext()){
//            Computer value = it.next();
//            System.out.println(value);
//        }


//        String name = testBean.getName();
//        System.out.println(name);
//        Computer computer = testBean.getComputer();
//        System.out.println(computer);
//        Map<Integer,String> map = testBean.getMap();
//        //key形式遍历
////        Set<Integer> keys = map.keySet();
////        Iterator<Integer> it = keys.iterator();
////        while(it.hasNext()){
////            Integer key = it.next();
////            String value = map.get(key);
////            System.out.println(key+"--"+value);
////        }
//        //entry形式遍历
//        Set<Map.Entry<Integer,String>> entrys = map.entrySet();
//        Iterator<Map.Entry<Integer,String>> it = entrys.iterator();
//        while (it.hasNext()){
//            Map.Entry<Integer,String> entry = it.next();
//            Integer key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key+"--"+value);
//        }


//        System.out.println(testBean.getName());
//        System.out.println(testBean.getComputer());
//        Map<String,Computer> map = testBean.getMap();
//        Set<Map.Entry<String,Computer>> entries = map.entrySet();
//        Iterator<Map.Entry<String,Computer>> it = entries.iterator();
//        while(it.hasNext()){
//            Map.Entry<String,Computer> entry = it.next();
//            String key = entry.getKey();
//            Computer value = entry.getValue();
//            System.out.println(key+"--"+value);
//        }


        //==========================================================================

        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        TestProperties tp = (TestProperties)factory.getBean("testProperties");
//        Properties properties = tp.getProperties();
//        //获取全部的key
//        Enumeration en = properties.propertyNames();//map.keySet();
//        //遍历全部的key
//        while(en.hasMoreElements()){
//            String key = (String)en.nextElement();
//            String value = properties.getProperty(key);//map.get(key);
//            System.out.println(key+"---"+value);
//        }


//        Room room = (Room)factory.getBean("room");
//        System.out.println(room);

        TestBean testBean = (TestBean)factory.getBean("testBean");
        System.out.println(testBean);
        System.out.println(testBean.getName());
        System.out.println(testBean.getComputer());
        System.out.println(testBean.getMap());





    }
}
