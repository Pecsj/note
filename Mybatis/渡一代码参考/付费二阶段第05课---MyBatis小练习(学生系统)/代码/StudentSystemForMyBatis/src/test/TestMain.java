package test;

import domain.Student;
import service.StudentService;
import util.MySpring;

import java.sql.Date;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        //创建Service对象
        StudentService service = MySpring.getBean("service.StudentService");
        //调用注册方法试一试
        //service.regist(new Student(20,"zzt",1,1995,new Date(System.currentTimeMillis())));

        //service.update(new Student(20,"zzt",0,1999,new Date(System.currentTimeMillis())));

        //service.delete(20);

//        Student student = service.selectOne(1);
//        System.out.println(student);

//        List<Student> studentList = service.selectAllByOrder("asc");
//        for(Student student : studentList){
//            System.out.println(student);
//        }
    }
}
