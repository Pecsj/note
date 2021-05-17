package myfiterchain;

public class TestMain {

    public static void main(String[] args){
        //1.Tomcat启动
        //2.读取web.xml配置文件
        //      目的获取   请求名--真实类全名对应关系
        //      Tomcat底层有一个集合(请求名字,对象)
        //      反射  通过类名创建对象
        FilterChain chain = new ApplicationFilterChain();
        chain.addFilter(new FilterOne());
        chain.addFilter(new FilterTwo());
        chain.addFilter(new FilterThree());
        //做事
        chain.doFilter();
    }
}
