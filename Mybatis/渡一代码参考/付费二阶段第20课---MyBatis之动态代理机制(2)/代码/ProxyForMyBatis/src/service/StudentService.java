package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

public class StudentService {

    //基于框架
//    private StudentDao dao = MyUtil.getSqlSession().getMapper(StudentDao.class);
    //自己写的
    private StudentDao dao = MyUtil.getSqlSession().getMapper(StudentDao.class);


    //设计一个业务的方法 注册 新增方法
    public void insertStudent(Student student){
        //判断以下当前更新的人主键是否冲突
        //if(){}
        dao.insert(student);
    }
}
