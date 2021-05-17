package service;

import dao.TeacherDao;
import domain.Teacher;

public class TeacherService {

    //添加TeacherDao作为属性
    private TeacherDao dao = new TeacherDao();

    //设计一个业务的方法 给定一个tid老师的编号 查询老师的信息+他教的所有学生信息
    public Teacher selectOne(Integer tid){
        return dao.selectOne(tid);
    }
}
