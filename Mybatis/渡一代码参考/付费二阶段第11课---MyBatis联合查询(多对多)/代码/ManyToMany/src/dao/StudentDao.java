package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class StudentDao {

    //需要一个SqlSession对象支持所有的JDBC操作
    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    //设计一个方法 根据sid学生编号 查询学生信息+这个学生所学老师的信息
    public Student selectOne(Integer sid){
        return sqlSession.selectOne("selectOne",sid);
    }
    //设计一个方法 查询所有学生信息+每个学生对应的老师信息
    public List<Student> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
