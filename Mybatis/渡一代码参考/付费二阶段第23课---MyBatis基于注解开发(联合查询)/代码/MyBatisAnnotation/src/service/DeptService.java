package service;

import dao.DeptDao;
import domain.Dept;
import util.MyUtil;

import java.util.List;

public class DeptService {

    private DeptDao dao = MyUtil.getMapper(DeptDao.class,true);

    //设计一个业务方法   给定部门编号  查询部门信息+所属于当前部门的所有员工信息
    public Dept selectOne(Integer deptno){
        return dao.selectOne(deptno);
    }

    //设计一个业务方法   查询全部的部门信息+每个部门中的所有员工信息
    public List<Dept> selectAll(){
        return dao.selectAll();
    }
}
