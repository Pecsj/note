package test;

import dao.StudentDao;
import domain.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        //dao.insert();

//        Student student = dao.selectOne(10);
//        System.out.println(student);

//        List<Student> studentList = dao.selectAll();
//        for(Student student : studentList){
//            System.out.println(student);
//        }

//        int count = dao.selectCount();
//        System.out.println(count);

//        String name = dao.selectNameById();
//        System.out.println(name);

//        List<Map<String,Object>> result = dao.selectCountBySex();
//        for(Map<String,Object> map : result){
//            System.out.println(map);
//        }

        //查询原来的真实结果
//        Student student = dao.selectOne(10);
//        System.out.println(student);//原始数据
//        if(student.getSex()==0){
//            student.setSex(1);
//        }else{
//            student.setSex(0);
//        }
//        //根据修改之后的性别 进行数据库的更新
//        dao.update(student);

        //map   意义  存储sex id
//        Map<String,Object> student = new HashMap<>();
//        student.put("sex",1);
//        student.put("id",10);
//        dao.update(student);


        List<Student> studentList = dao.selectAllByOrder("asc");
        for(Student student : studentList){
            System.out.println(student);
        }

    }
}
