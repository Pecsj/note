package service;

import dao.EmpDao;
import domain.Emp;

import java.util.List;

public class EmpService {

    private EmpDao dao = new EmpDao();

    //设计一个方法 提供一个empno员工编号 查询员工的信息+部门信息
    public Emp selectOne(Integer empno){
        return dao.selectOne(empno);
    }

    //设计一个方法 提供一个查询所有员工信息+部门信息
    public List<Emp> selectAll(){
        return dao.selectAll();
    }
}
