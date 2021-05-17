package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.List;

public class EmpService {

    private EmpDao dao = MyUtil.getMapper(EmpDao.class,true);

    //设计一个业务方法  根据给定的员工empno编号 查询员工的信息+所属的部门信息
    public Emp selectOne(Integer empno){
        return dao.selectOne(empno);
    }

    //设计一个业务方法  查询表格中全部的emp信息+每个员工所属的部门信息
    public List<Emp> selectAll(){
        return dao.selectAll();
    }

}
