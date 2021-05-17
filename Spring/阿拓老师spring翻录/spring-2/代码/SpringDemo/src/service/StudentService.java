package service;

import dao.StudentDao;

public class StudentService {

    private StudentDao dao = new StudentDao();

    public void login(){
        //1.方法应该有参数  Controller传递给我的
        //2.做一些业务处理  判断   dao调用查询方法----->
        //3.将判断的结果返回
    }
}
