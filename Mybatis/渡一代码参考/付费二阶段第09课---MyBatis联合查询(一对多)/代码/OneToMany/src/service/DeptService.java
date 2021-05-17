package service;

import dao.DeptDao;
import domain.Dept;

import java.util.List;

public class DeptService {

    private DeptDao dao = new DeptDao();

    //一个方法 查询单个dept对象
    public Dept selectOne(Integer deptno){
        return dao.selectOne(deptno);
    }

    //一个方法 查询多个dept对象
    public List<Dept> selectAll(){
        return dao.selectAll();
    }
}
