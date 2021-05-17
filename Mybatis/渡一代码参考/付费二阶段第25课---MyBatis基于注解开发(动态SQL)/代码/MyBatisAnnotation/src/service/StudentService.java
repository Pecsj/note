package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

import java.util.List;

public class StudentService {

    private StudentDao dao = MyUtil.getMapper(StudentDao.class,true);

    //学生业务类
    //需求    给定一个学生的sid编号    查询学生的信息+这个学生选课的老师信息
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    //所有学生的信息+每个学生对应的老师信息
    public List<Student> selectAll(){
        return dao.selectAll();
    }


















    /*
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


    //设计一个业务方法  查询学生详情(单条)
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    //设计一个业务方法  查询多条学生信息
    public List<Student> selectAll(){
        return dao.selectAll();
    }
    */

}
