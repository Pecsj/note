package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import domain.Person;
import domain.Student;
import service.PersonService;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
//        StudentService service = new StudentService();
        //学生删除
        //service.delete(12);

        //新增学生 注册
        //service.regist(new Student(11,"abc","nv",16));

//        Map map = new HashMap();
//        map.put("sid",12);
//        map.put("sname","opq");
//        map.put("ssex","nan");
//        map.put("sage",15);
//        service.regist(map);

//        service.regist(13,"lmn","nan",15);

//        Student student = service.selectOne(10);
//        System.out.println(student);

//        List<Student> studentList = service.selectAll();
//        for(Student s : studentList){
//            System.out.println(s);
//        }

        PersonService service = new PersonService();
//        Person person = service.selectOne(1);
//        System.out.println(person);

        List<Person> personList = service.selectAll();
        for(Person p:personList){
            System.out.println(p);
        }

    }
}
