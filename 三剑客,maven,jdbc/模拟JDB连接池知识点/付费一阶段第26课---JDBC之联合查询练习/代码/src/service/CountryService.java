package service;

import dao.CountryDao;

import java.util.ArrayList;
import java.util.HashMap;

public class CountryService {

    private CountryDao dao = new CountryDao();

    public ArrayList<HashMap<String,String>> select2(){
        return dao.select2();
    }

    public ArrayList<String> select11(int sumCitySize){
        return dao.select11(sumCitySize);
    }
}
