package dao;

import domain.Person;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class PersonDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    //设计一个方法 根据一个人的pid 查询人+身份证的所有信息
    public Person selectOne(Integer pid){
        return sqlSession.selectOne("selectOne",pid);
    }
    //设计一个方法 全部人员信息+人对应自己的身份证信息
    public List<Person> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
