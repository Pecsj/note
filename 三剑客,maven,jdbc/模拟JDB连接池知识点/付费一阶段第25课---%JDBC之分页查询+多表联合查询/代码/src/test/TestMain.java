package test;

import dao.EmpDao;
import domain.Emp;
import service.EmpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args){
        //当做是View层

        EmpDao dao = new EmpDao();
        ArrayList<HashMap<String,Object>> list = dao.selectCountByGroup();
        for(HashMap<String,Object> map:list){
            System.out.println(map.get("deptno")+"---"+map.get("ct"));
        }







//        EmpDao dao = new EmpDao();
//        ArrayList<Emp> list = dao.selectAllEmpAndDept();
//        for(Emp emp:list){
//            System.out.println(emp);
//        }





//        Scanner input = new Scanner(System.in);
//        System.out.println("请您输入需要查询的页码");
//        int page = input.nextInt();
//        EmpService service = new EmpService();
//        ArrayList<Emp> list = service.changePageToRowIndex(page);
//        for(Emp emp:list){
//            System.out.println(emp);
//        }









//        EmpDao dao = new EmpDao();
//        ArrayList<Emp> list = dao.selectForLike("R");
//        for(Emp emp:list){
//            System.out.println(emp);
//        }
    }
}
