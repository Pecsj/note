package service;

import dao.UserDao;
import domain.User;
import util.MySpring;
import util.ThreadLocalManager;

public class UserService {

    private UserDao dao = MySpring.getBean("dao.UserDao");

    //方案一   再设计一个方法 获取昵称    性能问题
//    public String getNickName(String uname){
//        String nickName = dao.selectOne(uname).getNickname();
//        System.out.println(nickName);
//        return nickName;
//    }


    //方法负责登录

//    public User login(String uname,String upassword){
//        User user = dao.selectOne(uname);//user对象 包含所有信息 name pass nick
////        if(user!=null && user.getUpassword().equals(upassword)){
////            return "登录成功";
////        }
////        return "用户名或密码错误";
//
//        //方案二   修改原有的登录方法
//        //方案二 将user对象整体返回   返回值类型与之前一个登录结果看似不同  不习惯
//        if(user!=null && user.getUpassword().equals(upassword)){
//            return user;
//        }
//        return user;
//    }

    //方案三  不改变原有登录方法结构的情况下  将domain对象带走
    //想要将结果带走 通常是返回值
    //想到了session的特点     某一个地方存储信息   隔着的地方取
    public String login(String uname,String upassword){
        User user = dao.selectOne(uname);
        //将domain对象拆开 做业务逻辑判断
        if(user!=null && user.getUpassword().equals(upassword)){
            // 对象.set("user",user);
            ThreadLocal local = ThreadLocalManager.getThreadLocal(uname);
            local.set(user);// local value
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
