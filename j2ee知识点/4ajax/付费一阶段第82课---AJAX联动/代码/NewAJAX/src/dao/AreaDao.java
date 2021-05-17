package dao;

import domain.Area;
import domain.Country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
@SuppressWarnings("ALL")
public class AreaDao {

    //设计一个方法 根据cid查询对应的所有地区
    public ArrayList<Area> selectAreaByCid(Integer cid){
        ArrayList<Area> areaList = new ArrayList<>();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cons?useSSL=false";
        String user = "root";
        String password = "root";
        String sql = "SELECT AID,ANAME,CID FROM AREA WHERE CID = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,cid);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Area area = new Area();
                area.setAid(rs.getInt("aid"));
                area.setAname(rs.getString("aname"));
                area.setCountry(new Country(rs.getInt("cid"),null));
                areaList.add(area);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return areaList;
    }
}
