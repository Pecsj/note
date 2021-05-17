package service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    //设计一个业务层的方法 负责登录逻辑
    public String login(String username,String password){
        if("zzt".equals(username) && "123".equals(password)){
            return "登录成功";
        }
        return "账号名或密码错误";
    }
}
