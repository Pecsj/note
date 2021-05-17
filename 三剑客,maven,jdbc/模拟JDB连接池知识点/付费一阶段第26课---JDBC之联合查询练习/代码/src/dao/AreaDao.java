package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AreaDao {

    private String className = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/cons?useSSL=true";
    private String user = "zzt";
    private String password = "123";

    //设计一个方法
    //1.查询人口数在1000到2000之间的城市所属在哪个地区
    //  是否有参数? 人口范围  1000 2000
    //  是否有返回值?  几个不同的地区名 ArrayList<String>
    public ArrayList<String> select1(int begin, int end){
        ArrayList<String> list = new ArrayList<String>();
        String sql = "select distinct aname from area a " +
                     "inner join city ci on a.aid = ci.aid " +
                     "where ci.citysize between ? and ?";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,begin);
            pstat.setInt(2,end);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                String value = rs.getString("aname");
                list.add(value);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
