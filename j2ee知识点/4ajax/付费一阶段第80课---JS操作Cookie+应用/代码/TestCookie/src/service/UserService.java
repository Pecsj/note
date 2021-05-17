package service;

public class UserService {

    public String login(String uname,String upass){
        if(uname.equals("zzt")&&upass.equals("123")){
            return "登录成功";
        }
        return "账号或密码错误";
    }
}
