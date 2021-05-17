package dao;

import domain.Student;

public class StudentDao {

    public Student selectOne(){
        //1.方法里面有参数 service层给我的
        System.out.println("dao层接收service层传递的信息");
        //2.自己写一条Sql语句
        System.out.println("执行数据库操作");
        //3.调用SqlSession做事就可以了
        System.out.println("将查询的结果返回");
        return null;
    }
}
