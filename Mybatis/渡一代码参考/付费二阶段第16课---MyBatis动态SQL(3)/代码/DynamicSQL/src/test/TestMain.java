package test;

import service.EmpService;

public class TestMain {

    public static void main(String[] args) {
        EmpService service = new EmpService();
        System.out.println(service.selectAllDeptno());
        System.out.println(service.selectAllJob());
    }
}
