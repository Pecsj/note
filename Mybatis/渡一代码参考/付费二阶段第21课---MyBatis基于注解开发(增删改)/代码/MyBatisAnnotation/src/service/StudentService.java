package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

import java.util.Map;

public class StudentService {

    //dao层对象作为属性
    private StudentDao dao = MyUtil.getMapper(StudentDao.class,true);

    //设计一个业务方法  删除学生
    public void delete(Integer sid){
        dao.delete(sid);
    }

    //设计一个业务方法  注册学生
//    public void regist(Student student){
//        dao.insert(student);
//    }
//    public void regist(Map map){
//        dao.insert(map);
//    }
    public void regist(Integer sid,String sname,String ssex,Integer sage){
        dao.insert(sid,sname,ssex,sage);
    }

}
