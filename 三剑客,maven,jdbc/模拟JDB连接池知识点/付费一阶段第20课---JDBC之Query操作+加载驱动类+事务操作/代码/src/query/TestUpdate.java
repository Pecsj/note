package query;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class TestUpdate {

    public static void main(String[] args){
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=CST";
            String user = "root";
            String password = "root";
            String sql = "select * from emp";
            //加载驱动
            //Class.forName(className);
            //DriverManager.registerDriver(new Driver());
            //new Driver();
            //System.setProperty("jdbc.driver","com.mysql.cj.jdbc.Driver");

            //获取连接
            Connection conn = DriverManager.getConnection(url,user,password);
            //创建状态参数
            Statement stat = conn.createStatement();
            //执行一个update操作(DML) DDL
//            int count = stat.executeUpdate(sql);//有返回值  表示数据库更新的行数
//            System.out.println("执行完毕");
            //执行一个query操作(DQL)   数据库没发生真实的变化  我需要得到结果 做处理  肯定需要返回值
            //一行记录  里面有8个值  一堆的值怎么存?Map<String,Object>
            //  数组[8] Object[8]
            //  集合List<Object>  Set<Object>  Map<String,Object>
            //  Map<列名key,单元格内的值value>
            //     empno=7369 ename=smith job=clerk mgr=7902 hiredate=1980-1-1 sam=800 comm=null deptno=10
            //  一行记录-->Map集合    14行记录--14Map集合
            //  Set<map>  set目的是为了存储好多行记录  每一行是一个map对象
            //            map目的是为了存储一行中多个单元格的值  key列名  value单元格查询出来
            //  Set<Map<String,Object>>
            //  Iterator it = set.iterator();
            //      it.hasNext();判断是否有下一个元素  it.next()获取
            //  Enumeration en = pro.propertyNames();
            //      en.hasMoreElements();判断是否有下一个元素  en.nextElement();获取
            //  ResultSet rs = stat.executeQuery(sql);
            //      rs.next();判断是否有下一个元素    rs.getXXX(key);获取

            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
//                int value = rs.getInt("hiredate");//String---int  Integer.parseInt("abc");
//                System.out.println(value);
                int empno = rs.getInt(1);
                String ename = rs.getString("ename");
                Date hiredate = rs.getDate("hiredate");//java.util  java.sql
                float sal = rs.getFloat("sal");
                System.out.println(empno+"--"+ename+"--"+hiredate+"--"+sal);
            }
            System.out.println("执行完毕");
            //关闭操作
            rs.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
