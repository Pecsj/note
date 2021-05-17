package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class StudentDao {

    //dao中存储一个sqlsession属性
    private SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true);

    public void insert(Student student){
        sqlSession.insert("insert",student);
    }
    public void update(Student student){
        sqlSession.update("update",student);
    }
    public void delete(Integer id){
        sqlSession.delete("delete",id);
    }
    public Student selectOne(Integer id){
        return sqlSession.selectOne("selectOne",id);
    }
    public List<Student> selectAllByOrder(String flag){
        return sqlSession.selectList("selectAllByOrder",flag);
    }
}
