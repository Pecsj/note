package service;

import dao.CountryDao;
import domain.Country;

import java.util.ArrayList;

public class CountryService {

    //需要一个dao作为属性
    private CountryDao dao = new CountryDao();

    //一个查询所有国家的方法
    public ArrayList<Country> selectAllCountry(){
        return dao.selectAllCountry();
    }
}
