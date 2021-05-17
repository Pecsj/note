package dao;

import domain.Teacher;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

public class TeacherDao {

    //需要一个SqlSession对象作为属性 让他负责JDBC操作
    private SqlSession sqlSession = MyUtil.getSqlSession(true);


    //设计一个方法 负责根据tid老师编号 查询一个老师的信息+他所有学生的信息
    public Teacher selectOne(Integer tid){
        return sqlSession.selectOne("selectOne",tid);
    }
}
