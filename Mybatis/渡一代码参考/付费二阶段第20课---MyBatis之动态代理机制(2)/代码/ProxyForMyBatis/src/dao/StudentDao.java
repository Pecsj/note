package dao;

import domain.Student;

public interface StudentDao {

//    //属性
//    private SqlSession sqlSession = new SqlSessionFactory().openSession();
//
//    //dao中有一个具体的方法
//    //负责执行数据库的写操作
//    public void insert(Student student){
//        sqlSession.insert("sqlid",student);
//    }

    public void insert(Student student);//dao变成接口的时候 方法名字 必须与sqlid
}
