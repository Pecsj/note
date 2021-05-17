package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.List;

public class EmpService {

    private EmpDao dao = MyUtil.getMapper(EmpDao.class,true);

//    //设计一个业务方法  根据给定的员工empno编号 查询员工的信息+所属的部门信息
//    public Emp selectOne(Integer empno){
//        return dao.selectOne(empno);
//    }
//
//    //设计一个业务方法  查询表格中全部的emp信息+每个员工所属的部门信息
//    public List<Emp> selectAll(){
//        return dao.selectAll();
//    }



    //====================================================================
    //给定两个不同的条件     job  deptno
    //  用户提供的   可有可无
    //  根据条件动态拼接SQL执行查询
    //  都没有     select * from emp where 1=1;
    //  job       select * from emp where 1=1 and job = #{job}
    //  deptno    select * from emp where 1=1 and deptno = #{deptno}
    //  两个条件    select * from emp where 1=1 and job = #{job} and deptno = #{deptno}


//    public List<Emp> selectEmpsByJobAndDeptno(String job,Integer deptno){
//        return dao.selectEmpsByJobAndDeptno(job,deptno);
//    }


    //根据给定的好多empno查询符合的人
    //      7369 7788 7902 7654 7839
    //      select * from emp where empno in (#{empno},#{empno},7902,7654,7839)
    public List<Emp> selectEmpsByEmpno(Integer... empnos){
        return dao.selectEmpsByEmpno(empnos);
    }



}
