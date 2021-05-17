package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层
 *          为了controller做业务支持
 *
 *          业务层中的方法主要做   比较  计算  判断  等核心业务
 *          1.参数通常是controller给的
 *          2.核心业务是自己处理
 *                  需要数据的支持----DAO
 */
@Service("studentService")
public class StudentService {

    //属性 DAO小弟
    private StudentDao dao;
    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    //自己业务方法
    public void serviceMethod(String ssex){
        System.out.println("serviceMethod");
        dao.select(ssex);
    }
}
