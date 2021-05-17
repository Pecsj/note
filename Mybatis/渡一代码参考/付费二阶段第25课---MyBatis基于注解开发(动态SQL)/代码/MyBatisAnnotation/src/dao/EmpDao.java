package dao;

import domain.Dept;
import domain.Emp;
import dynamic.EmpDynamic;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface EmpDao {

//    //设计一个方法  根据员工empno编号 查询员工信息+所属部门信息
//    @Results(
//            id="selectEmp",
//            value={
//                    @Result(property="empno",column="empno",id=true),
//                    @Result(property="ename",column="ename"),
//                    @Result(property="job",column="job"),
//                    @Result(property="mgr",column="mgr"),
//                    @Result(property="hiredate",column="hiredate"),
//                    @Result(property="sal",column="sal"),
//                    @Result(property="comm",column="comm"),
//                    @Result(property="dept",javaType=Dept.class,column="deptno",one=@One(select="selectDept",fetchType=FetchType.LAZY))
//            })
//    @Select("select * from emp where empno = #{empno}")
//    public Emp selectOne(Integer empno);
//
//    //辅助方法
//    @Select("select * from dept where deptno = #{deptno}")
//    public Dept selectDept(Integer deptno);


    //====================================================
    //查询所有的emp信息+每个emp对应的dept对象
//    @Select("select * from emp")
//    @ResultMap("selectEmp")
//    public List<Emp> selectAll();




    //====================================================
    //支持动态SQL的方法    代理处理

    //根据给定的job和deptno查询好多人  job和deptno不一定有没有
//    @Select("动态---找别人拼接完成拿回来")
//    @SelectProvider(EmpDynamic.class)
//    public List<Emp> selectEmpsByJobAndDeptno(@Param("job")String job,@Param("deptno")Integer deptno);


    //根据给定的empno查询好多人   empno不一定有几个
    @SelectProvider(type=EmpDynamic.class,method="getDynamicSQL")
    public List<Emp> selectEmpsByEmpno(@Param("empnos")Integer... empnos);

}
