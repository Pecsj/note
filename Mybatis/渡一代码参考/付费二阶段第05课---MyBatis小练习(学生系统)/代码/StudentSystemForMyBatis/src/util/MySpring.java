package util;

import java.util.HashMap;
import java.util.Map;

public class MySpring {

    //用来存储好多对象的集合
    private static Map<String,Object> beanMap = new HashMap();

    //设计一个方法 用来管理对象的产生 变成单例模式
    public static synchronized <T> T getBean(String className){
        T obj = (T)beanMap.get(className);
        if(obj==null){
            try {
                obj = (T)Class.forName(className).newInstance();
                beanMap.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
