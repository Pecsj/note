package service;

import dao.StudentDao;
import domain.Student;
import util.MySpring;

import java.util.List;

public class StudentService {

    //一个dao对象作为属性
    private StudentDao dao = MySpring.getBean("dao.StudentDao");

    //注册方法 新增
    public void regist(Student student){
        dao.insert(student);
    }
    //修改方法 除了id以外都可以修改
    public void update(Student student){
        dao.update(student);
    }
    //删除方法 根据id找到一行记录 删掉
    public void delete(Integer id){
        dao.delete(id);
    }
    //查询单条记录 根据id查询
    public Student selectOne(Integer id){
        return dao.selectOne(id);
    }
    //查询全部记录 按照id编号排序 升序/降序不一定
    public List<Student> selectAllByOrder(String flag){
        return dao.selectAllByOrder(flag);
    }

}
