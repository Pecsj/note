package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SqlSession {

    //可以理解为 这个类的对象 是以前我们MyBatis提供的对象

    //预先将mapper.xml文件全部内容读取并解析的过程
    static{
        //读取mapper.xml文件内容
        //解析内容
        //      <mapper namespace="dao.StudentDao">
        //          <insert id="sqlid">
        //              insert into student values(#{sid},#{sname},#{ssex},#{sage})
        //          </insert>
        //      </mapper>

        //      mapper类型的对象(namespace属性 List<Insert对象> list<Update对象>)
        //      insert类型的对象(id属性 sql属性)
        //      update类型的对象(id属性 sql属性)
    }

    public void insert(String sqlid,Object obj){
        //应该做什么？？？？？
        //原来的JDBC流程
        //1.导包
        //2.加载驱动
        //*3.获取连接(连接池方式管理)
        //*4.通过传递的sqlid找寻一条SQL语句(解析XML文件)
        //5.创建状态参数(预处理 优先加载SQL语句)
        //*6.SQL语句和提供的参数信息组合完整(分析SQL语句#{key},反射在obj对象中找value)
        //7.执行操作executeUpdate();
        //8.关闭
        System.out.println("我是SqlSession中的insert方法，我执行了好多好多");
    }

    public <T>T getMapper(Class clazz){
        //创建代理对象
        //  ClassLoader 需要被代理的类[] 做哪一件事情(方法)
        ClassLoader loader = clazz.getClassLoader();
        Class[] classes = new Class[]{clazz};
        InvocationHandler handler = new InvocationHandler() {
            //这个invoke方法相当于是代理对象的真正执行方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是代理执行的方法");
                System.out.println("代理对象"+proxy.getClass().getName());
                System.out.println("代理对象代替真实对象做的方法"+method.getName());
                System.out.println("代理对象接收到真实对象的参数"+args[0]);
                //insert("sqlid",student);
                return proxy;
            }
        };
        Object obj = Proxy.newProxyInstance(loader,classes,handler);//代理对象(原来Dao接口的子类)
        //做一个造型
        T t = (T)obj;
        //造型以后的代理对象返回出去
        //代理对象是传递进来参数Class类型的子类对象
        return t;
    }

}
