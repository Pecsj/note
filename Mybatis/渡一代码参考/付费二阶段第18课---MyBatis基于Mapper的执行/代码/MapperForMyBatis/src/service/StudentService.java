package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

public class StudentService {

    //业务层   数据处理
    //属性
    private StudentDao dao = MyUtil.getSqlSession(true).getMapper(StudentDao.class);

    //新增学生
    public void insertStudent(Student student){
        dao.insert(student);//不是我们的dao执行的 我们的dao下面的小弟(Mapper代理)执行的
    }
    //删除学生
    public void deleteStudent(Integer sid){
        dao.delete(sid);
    }
    //修改学生
    public void updateStudent(Student student){
        dao.update(student);
    }
    //查看学生
    public Student selectStudent(Integer sid){
        return dao.selectOne(sid);
    }
}
