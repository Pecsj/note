package dao;

import domain.Emp;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class EmpDao {

    //一个sqlSession对象
    private SqlSession sqlSession = MyUtil.getSqlSession(true);


    //设计一个方法 提供一个empno员工编号 查询员工的信息+部门信息
    public Emp selectOne(Integer empno){
        return sqlSession.selectOne("selectOne",empno);
    }

    //设计一个方法 提供一个查询所有员工信息+部门信息
    public List<Emp> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
