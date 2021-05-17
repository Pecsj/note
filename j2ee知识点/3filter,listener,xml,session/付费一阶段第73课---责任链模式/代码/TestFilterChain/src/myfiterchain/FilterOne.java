package myfiterchain;

public class FilterOne extends HttpFilter{

    public void doFilter(FilterChain chain) {
        //做自己的事情
        System.out.println("one回答问题");
        //找管理者 让管理者找下一个人  放行
        chain.doFilter();
    }
}
