package dao;

import domain.Dept;
import domain.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DeptDao {

    //设计一个方法  根据部门编号deptno   查询部门的信息+所属于当前部门的所有员工信息
    @Results(
            id="selectDept",
            value={
                    @Result(property="deptno",column="deptno",id=true),
                    @Result(property="dname",column="dname"),
                    @Result(property="loc",column="loc"),
                    @Result(property="empList",javaType=List.class,column="deptno",many=@Many(select="selectEmp",fetchType=FetchType.LAZY)),
            }
    )
    @Select("select * from dept where deptno = #{deptno}")
    public Dept selectOne(Integer deptno);


    //辅助方法
    @Select("select * from emp where deptno = #{deptno}")
    public Emp selectEmp(Integer deptno);

    //==========================================================

    @Select("select * from dept")
    @ResultMap("selectDept")
    public List<Dept> selectAll();
}
