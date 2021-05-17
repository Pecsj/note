package service;

import dao.StudentDao;

public class StudentService {

    private StudentDao dao;
    public StudentService(StudentDao dao) {
        this.dao = dao;
    }

    public void login(){
        //1.方法应该有参数  Controller传递给我的
        System.out.println("service层接收请求发来的信息");
        //2.做一些业务处理  判断   dao调用查询方法----->
        dao.selectOne();
        //3.将判断的结果返回
        System.out.println("service层处理业务并返回");
    }
}
