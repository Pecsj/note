package test;

import dao.EmpDao;
import domain.Emp;

import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args){
        EmpDao dao = new EmpDao();
        ArrayList<Emp> list = dao.selectForLike("R");
        for(Emp emp:list){
            System.out.println(emp);
        }
    }
}
