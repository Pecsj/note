package test;

import domain.Dept;
import domain.Emp;
import service.DeptService;
import service.EmpService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        //根据给定的empno员工编号 查询员工的信息+对应的部门信息
//        EmpService empService = new EmpService();
////        Emp emp = empService.selectOne(7839);
////        System.out.println(emp.getEmpno()+"--"+emp.getEname()+"--"+emp.getSal());
//
//        //查询所有员工信息+对应的部门信息
//        List<Emp> empList = empService.selectAll();
//        for(Emp e:empList){
//            System.out.println(e.getEmpno()+"--"+e.getEname()+"--"+e.getSal()+"--"+e.getDept().getDeptno());
//        }


        //根据部门编号 查询部门信息+当前部门中所有员工信息
        DeptService deptService = new DeptService();
//        Dept dept = deptService.selectOne(20);
//        System.out.println(dept.getDeptno()+"--"+dept.getDname()+"--"+dept.getLoc()+"--"+dept.getEmpList());

        //查询所有部门的信息+每个部门中所有员工的信息
        List<Dept> deptList = deptService.selectAll();
        for(Dept d : deptList){
            System.out.println(d);
        }

    }
}
