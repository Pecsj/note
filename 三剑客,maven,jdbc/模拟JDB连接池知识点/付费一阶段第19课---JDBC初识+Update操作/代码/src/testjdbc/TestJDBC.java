package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

    public static void main(String[] args){
        try {
            //1.导包
            //2.加载驱动类       com.mysql.jdbc.Driver
            String className = "com.mysql.jdbc.Driver";
            Class.forName(className);//加载类 类中的静态元素就执行啦
            //3.获取连接    DriverManager
            //   jdbc:mysql://ip:port/database名
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);
            //4.创建状态参数
            Statement stat = conn.createStatement();
            //5.执行操作
            //      写DML-->insert delete update (三个都做了数据库更新)
            //      stat.executeUpdate(String sql);
            //String sql = "insert into emp(empno,ename) values(9999,'zzt')";
            String sql = "delete from emp where empno = 9999";
            stat.executeUpdate(sql);
            System.out.println("执行完毕");
            //      读DQL-->select               (没有做数据库更新 但是需要处理结果)
            //      ? = stat.executeQuery(String sql);
            //6.关闭
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
