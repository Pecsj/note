package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class StudentDao {

    //设计一个方法 根据sex分组 每一个组中的人数
    public List<Map<String,Object>> selectCountBySex(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        List<Map<String,Object>> result = sqlSession.selectList("selectCountBySex");
        return result;
    }

    //设计一个方法 根据编号查询对应的人名
    public String selectNameById(){//缺少一个参数id
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        String name = sqlSession.selectOne("selectNameById");
        return name;
    }

    //设计一个方法 查询表格中记录的个数
    public int selectCount(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        int ct = sqlSession.selectOne("selectCount");
        return ct;
    }


    //设计一个方法 查询表格中的全部内容
    public List<Student> selectAll(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        List<Student> studentList = sqlSession.selectList("selectAll");//SQL语句的id  SQL上面的问号信息  告知每一行记录存储的类型
        return studentList;
    }







    //设计一个方法 查询单条记录     读操作 携带返回值
    public Student selectOne() {//应该需要参数  先固定
        //JDBC+SQL      告知SQL  告知SQL上面的问号信息(可以有 可以没有)  告知容器(一行记录)类型
        //加载驱动
        //获取连接
        //状态参数   conn.prepareStatement(sql);
        //将SQL和问号信息拼接完整
        //执行操作   ResultSet = executeQuery();
        //结果集中查询出来的信息 取出来存在一个新的容器内(数组 List Set Map domain)  结果集关掉啦
        //关闭操作   rs.close()   pstat.close()   conn.close();
        //返回那个新的容器

        //找寻sqlSession对象就可以啦
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml");
        //InputStream inputStream = Resources.getResourceAsStream("configuration.xml");
        //下面第二种方式获取输入流  几个点需要大家注意
        //  1.Resources这个类是MyBatis框架提供   依赖度比较高
        //  2.方法与之前我们利用ClassLoader加载的方法名一致      框架提供的方法有异常必须处理
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession(true);
        //让sqlSession帮我们做事
        Student student = sqlSession.selectOne("selectOne");//1.SQL语句的id  SQL语句上面的问号信息(暂时没有)  查询完毕的结果装到什么容器里
        return student;
    }









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
