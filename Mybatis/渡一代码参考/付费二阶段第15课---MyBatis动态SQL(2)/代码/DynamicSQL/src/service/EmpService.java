package service;

import dao.EmpDao;
import domain.Emp;

import java.util.List;

public class EmpService {

    private EmpDao dao = new EmpDao();

    //提供一个业务方法 根据给定的两个信息条件 查询emp对象的结果
    public List<Emp> selectEmp(String deptno,String job){
        return dao.selectEmp(deptno,job);
    }



    //提供两个业务
    public List<Integer> selectAllDeptno(){
        return dao.selectAllDeptno();
    }
    public List<String> selectAllJob(){
        return dao.selectAllJob();
    }

}
