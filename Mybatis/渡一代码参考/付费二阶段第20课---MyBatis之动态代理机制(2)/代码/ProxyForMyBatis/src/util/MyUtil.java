package util;


import proxy.SqlSession;
import proxy.SqlSessionFactory;

public class MyUtil {

    //采用框架的执行
//    private static SqlSessionFactory factory;
//    static{
//        factory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
//    }
//    public static SqlSession getSqlSession(){
//        return factory.openSession();
//    }

    //自己定义的执行
    private static SqlSessionFactory factory;
    static {
        factory = new SqlSessionFactory();
    }
    public static SqlSession getSqlSession(){
        return factory.openSession();
    }
}
