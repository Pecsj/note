package test;

import domain.Emp;
import service.EmpService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        //根据给定的empno员工编号 查询员工的信息+对应的部门信息
        EmpService empService = new EmpService();
//        Emp emp = empService.selectOne(7839);
//        System.out.println(emp.getEmpno()+"--"+emp.getEname()+"--"+emp.getSal());

        //查询所有员工信息+对应的部门信息
        List<Emp> empList = empService.selectAll();
        for(Emp e:empList){
            System.out.println(e.getEmpno()+"--"+e.getEname()+"--"+e.getSal()+"--"+e.getDept().getDeptno());
        }
    }
}
