package service;

import dao.StudentDao;
import domain.Student;

import java.util.List;

public class StudentService {

    //StudentDao作为属性 支持下面的业务操作
    private StudentDao dao = new StudentDao();

    //根据学生的id 查询学生的信息+这个学生听了哪些老师的课
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    //查询所有学生的信息 + 每一个学生对应的那些老师信息
    public List<Student> selectAll(){
        return dao.selectAll();
    }
}
