package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class StudentDao {


    //设计一个方法 查询单个学生信息
//    public Student selectOne(Integer sid){
//        //找到SqlSession对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml");
//        SqlSessionFactory factory = builder.build(inputStream);
//        SqlSession sqlSession = factory.openSession(true);
//
//        //让sqlSession做事
//        return sqlSession.selectOne("selectOne",sid);
//    }

    //查询学生的方法   JDBC+SQL
    public Student selectOne(Integer sid){
        //先找到SqlSession对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml");
        SqlSessionFactory factory = builder.build(inputStream,"development2");
        SqlSession sqlSession = factory.openSession();//连接数据库
        //让sqlSession做事
        //return sqlSession.selectOne("selectOne",sid);
        return null;
    }




}
