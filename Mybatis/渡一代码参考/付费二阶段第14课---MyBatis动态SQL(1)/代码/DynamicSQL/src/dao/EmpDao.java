package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class EmpDao {


    //设计两个方法 分别查询所有的deptno  和  所有的job
    public List<Integer> selectAllDeptno(){
        List<Integer> deptnoList = new ArrayList();
        try {
            //原生JDBC
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testmybatis?useSSL=false";
            String username = "root";
            String password = "123456";
            String sql = "select distinct deptno from emp order by deptno";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                deptnoList.add(rs.getInt("deptno"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptnoList;
    }

    public List<String> selectAllJob(){
        List<String> jobList = new ArrayList();
        try {
            //原生JDBC
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testmybatis?useSSL=false";
            String username = "root";
            String password = "123456";
            String sql = "select distinct job from emp order by job";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                jobList.add(rs.getString("job"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobList;
    }
}
