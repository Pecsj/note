package myfiterchain;

import java.util.ArrayList;

//这个类是负责将所有filter对象 串联起来的
public class ApplicationFilterChain implements FilterChain {

    //需要一个容器 将所有的filter对象都存起来  集合list set
    private ArrayList<Filter> filterList = new ArrayList();
    //用来记录位置(索引)
    private int index = 0;

    //提供一个方法 将反射创建出来的对象存入集合内
    public void addFilter(Filter filter){
        filterList.add(filter);
    }

    //设计一个方法 每一次找寻一个责任人
    public void doFilter(){
        if(index < filterList.size()){
            Filter currentFilter = filterList.get(index++);//找到一个人 按顺序找
            //让当前的责任人做事(回答问题)
            currentFilter.doFilter(this);
        }else{
            //找真正的资源
            //findController();
            System.out.println("该找寻真正资源做事");
        }
    }
}
