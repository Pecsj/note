package service;

import dao.EmpDao;
import domain.Emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpService {

    private EmpDao dao = new EmpDao();

    //提供一个业务方法 根据给定的两个信息条件 查询emp对象的结果
    public List<Emp> selectEmp(String deptno,String job,String orderFlag){
        //调用原生JDBC实现的方法 传递两个散值
        //return dao.selectEmp(deptno,job);

        //调用MyBatis实现的方法 传递一个对象(map domain)
        //将两个参数包装成一个map
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("deptno",deptno);
        params.put("job",job);
        params.put("orderFlag",orderFlag);
        return dao.selectEmpByMybatis(params);
    }


    //提供两个业务
    public List<Integer> selectAllDeptno(){
        return dao.selectAllDeptno();
    }
    public List<String> selectAllJob(){
        return dao.selectAllJob();
    }

}
