package test;

import service.AreaService;
import service.CountryService;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {

    public static void main(String[] args){
        CountryService countryService = new CountryService();
        AreaService areaService = new AreaService();

        //select11
        ArrayList<String> list11 = countryService.select11(3000);
        for(String value:list11){
            System.out.println(value);
        }

        //select2
//        ArrayList<HashMap<String,String>> list2 = countryService.select2();
//        for(HashMap<String,String> map:list2){
//            System.out.println(map.get("cname")+"--"+map.get("citycount"));
//        }


        //select1
//        ArrayList<String> list1 = areaService.select1();
//        for(String value:list1){
//            System.out.println(value);
//        }
    }
}
