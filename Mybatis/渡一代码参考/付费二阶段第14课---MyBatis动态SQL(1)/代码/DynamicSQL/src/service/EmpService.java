package service;

import dao.EmpDao;

import java.util.List;

public class EmpService {

    private EmpDao dao = new EmpDao();

    //提供两个业务
    public List<Integer> selectAllDeptno(){
        return dao.selectAllDeptno();
    }
    public List<String> selectAllJob(){
        return dao.selectAllJob();
    }
}
