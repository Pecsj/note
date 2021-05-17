package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class StudentDao {

    //设计一个方法 新增一条学生记录
    public void insert(){
        //JDBC流程----不需要我们写啦
        //MyBatis帮我们做操作

        //创建工人对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml");
        //获取工厂对象
        SqlSessionFactory factory = builder.build(inputStream);//图纸 核心配置文件
        //获取提供的那个对象SqlSession
        SqlSession sqlSession = factory.openSession(true);//自动开启事务 自动提交  默认false 自动开启事务  不提交
        //帮我们执行数据库操作    增删改
        sqlSession.insert("insert");//加载驱动 获取连接(连接池) 创建状态参数

        //sqlSession.commit();
    }

}
