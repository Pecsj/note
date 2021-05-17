package service;

import dao.UserDao;
import domain.User;

public class UserService {

    private UserDao dao = new UserDao();

    //检测名字是否存在
    public String checkName(String uname){
        User user = dao.selectOne(uname);
        if(user!=null){
            return "名字已存在";
        }
        return "名字可用";
    }
}
