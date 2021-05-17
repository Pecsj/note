package service;

import dao.AtmDao;
import domain.Atm;

public class AtmService {

    private AtmDao dao = new AtmDao();

    //设计一个登录方法
    public String login(String aname,String apassword){
        String result = "用户名或密码错误";
        Atm atm = dao.selectOne(aname);
        if(atm.getApassword().equals(apassword)){
            result = "登录成功";
        }
        return result;
    }

}
