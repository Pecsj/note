package dao;

import domain.Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AtmDao {

    public Atm selectOne(String aname){
        Atm atm = null;
        String className = "com.mysql.jdbc.Driver";//5.x版本   8.x-->com.mysql.cj.jdbc.Driver
        String url = "jdbc:mysql://localhost:3306/atm?useSSL=true";
        String user = "zzt";
        String password = "123";
        String sql = "select * from atm where aname = ?";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);//预处理状态参数
            //给sql语句中的问号赋值
            pstat.setString(1,aname);
            ResultSet rs = pstat.executeQuery();
            //3.将结果集内的信息取出来 存入一个对象
            if(rs.next()){
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atm;
    }
}
