package test;

import domain.Atm;

import java.sql.*;

public class TestAtm {

    //发现登录方法和查询余额的方法内部好多程序都一致  出现代码的冗余
    //设计一个方法  做那些重复的事情   查询一行记录
    //  参数?---->用户名 返回值?---->???
    public Atm selectOne(String aname){
        Atm atm = null;
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "zzt";
        String password = "123";
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM ATM WHERE ANAME = '"+aname+"'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url,user,password);
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                //证明用户名存在 查询到了一行记录  返回值?
                //将结果集内的数据取出来 数据存在一个容器里  对象domain
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(stat!=null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atm;
    }

    //-----------------------------------------------------------------------

    //登录
    public String login(String aname,String apassword){
        Atm atm = this.selectOne(aname);
        if(atm!=null && atm.getApassword().equals(apassword)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
    //查询余额
    public float cha(String aname){
        return this.selectOne(aname).getAbalance();
    }

    //存款

    //取款

    //转账

    //开户

    //销户
}
