package dao;

import domain.Person;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

public class PersonDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    //设计一个方法 根据一个人的pid 查询人+身份证的所有信息
    public Person selectOne(Integer pid){
        return sqlSession.selectOne("selectOne",pid);
    }
}
