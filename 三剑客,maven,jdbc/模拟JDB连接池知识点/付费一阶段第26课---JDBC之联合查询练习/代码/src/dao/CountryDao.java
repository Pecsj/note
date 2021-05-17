package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class CountryDao {

    private String className = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/cons?useSSL=true";
    private String user = "zzt";
    private String password = "123";

    //设计一个方法
    //2.查询每个国家的城市个数 按照城市个数升序排列
    //  是否需要参数?  无
    //  是否要返回值?  ArrayList<HashMap<String,String>>
    public ArrayList<HashMap<String,String>> select2(){
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        String sql = "select c.cname,count(ci.cityid) as citycount \n" +
                     "from country c inner join area a \n" +
                     "on c.cid = a.cid inner join city ci \n" +
                     "on a.aid = ci.aid group by c.cname\n" +
                     "order by citycount asc";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,String> map = new HashMap<>();
                map.put("cname",rs.getString("cname"));
                map.put("citycount",rs.getString("citycount"));
                list.add(map);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //设计一个方法
    //11.查询人口总数超过5000的国家名称
    //  是否需要参数?---> 人口总数(每个国家的人口总数)
    //  是否需要返回值?---->   Array<String>
    public ArrayList<String> select11(int sumCitySize){
        ArrayList<String> list = new ArrayList<>();
        String sql = "select c.cname from country c \n" +
                     "inner join area a on c.cid = a.cid \n" +
                     "inner join city ci on a.aid = ci.aid\n" +
                     "group by c.cname \n" +
                     "having sum(ci.citysize) > ?";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,sumCitySize);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                String value = rs.getString("cname");
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
