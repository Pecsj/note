package dao;

import domain.Country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CountryDao {

    //查询所有的国家
    public ArrayList<Country> selectAllCountry(){
        ArrayList<Country> countryList = new ArrayList<>();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cons?useSSL=false";
        String user = "root";
        String password = "root";
        String sql = "SELECT CID,CNAME FROM COUNTRY";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                countryList.add(new Country(rs.getInt("cid"),rs.getString("cname")));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;
    }
}
