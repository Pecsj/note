package myfiterchain;

//一个接口 为了隐藏真实ApplicationFilterChain的执行过程
public interface FilterChain {

    void addFilter(Filter filter);
    void doFilter(HttpServletRequest request,HttpServletResponse response);
}
