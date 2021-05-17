package myfiterchain;

//定义规则
//定义方法名字 参数等
public interface Filter {

    void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain);
}
