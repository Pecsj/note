package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    //负责查询单条记录
    public User selectOne(String uname){
        User resultUser = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/shopping?useSSL=true";
            String user = "root";
            String password = "root";
            String sql = "SELECT UNAME,UPASSWORD,NICKNAME FROM USER WHERE UNAME = ?";
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,uname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                resultUser = new User();
                resultUser.setUname(rs.getString("uname"));
                resultUser.setUpassword(rs.getString("upassword"));
                resultUser.setNickName(rs.getString("nickName"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultUser;
    }
}
