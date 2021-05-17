package service;

import dao.TeacherDao;
import domain.Teacher;
import util.MyUtil;

import java.util.List;

public class TeacherService {

    private TeacherDao dao = MyUtil.getMapper(TeacherDao.class,true);

    //老师业务类
    //需求    给定一个老师的tid编号    查询老师的信息+这个老师教所有学生的信息
    public Teacher selectOne(Integer tid){
        return dao.selectOne(tid);
    }

    public List<Teacher> selectAll(){
        return dao.selectAll();
    }
}
