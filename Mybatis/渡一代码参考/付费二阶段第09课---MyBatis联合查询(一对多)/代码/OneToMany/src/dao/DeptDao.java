package dao;

import domain.Dept;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class DeptDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    //设计一个方法 根据给定的deptno部门编号 查询部门信息+这个部门中的所有员工信息
    public Dept selectOne(Integer deptno){
        return sqlSession.selectOne("selectOne",deptno);
    }

    //设计一个方法 查询所有部门的信息 + 每一个部门中的所有员工信息
    public List<Dept> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
