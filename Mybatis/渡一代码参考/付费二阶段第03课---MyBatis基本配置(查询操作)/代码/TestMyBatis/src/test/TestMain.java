package test;

import dao.StudentDao;
import domain.Student;

import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        //dao.insert();

//        Student student = dao.selectOne();
//        System.out.println(student);

//        List<Student> studentList = dao.selectAll();
//        for(Student student : studentList){
//            System.out.println(student);
//        }

//        int count = dao.selectCount();
//        System.out.println(count);

//        String name = dao.selectNameById();
//        System.out.println(name);

        List<Map<String,Object>> result = dao.selectCountBySex();
        for(Map<String,Object> map : result){
            System.out.println(map);
        }
    }
}
