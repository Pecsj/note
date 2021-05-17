package util;

import java.util.HashMap;

public class ThreadLocalManager {

    //管理不同的ThreadLocal对象    一个人分配一个ThreadLocal
    //用每一个人登录的账号作为key   每一个ThreadLocal对象作为值
    private static HashMap<String,ThreadLocal> localMap = new HashMap<>();

    //通过登录账号获取自己对应的那一个local对象
    public static ThreadLocal getThreadLocal(String name){
        ThreadLocal local = localMap.get(name);
        if(local==null){
            local = new ThreadLocal();
            localMap.put(name,local);
        }
        return local;
    }

}
