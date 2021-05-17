package test;

import dao.StudentDao;
import domain.Student;

import java.util.HashMap;

public class TestMain {

    public static void main(String[] args) {
        //创建dao对象
        StudentDao dao = new StudentDao();
        //调用查询单条记录的方法
        Student student = dao.selectOne(1);
        System.out.println(student);

//        HashMap<String,Object> result = dao.selectOne(1);
//        System.out.println(result);
    }
}
