package dao;

import domain.IDCard;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class IDCardDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    //根据身份证号 查询人+身份证信息
    public IDCard selectOne(String cardid){
        return sqlSession.selectOne("selectOne",cardid);
    }
    //全部信息查询
    public List<IDCard> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
