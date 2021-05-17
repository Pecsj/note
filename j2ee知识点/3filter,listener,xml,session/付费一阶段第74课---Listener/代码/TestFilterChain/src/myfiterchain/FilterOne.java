package myfiterchain;

public class FilterOne extends HttpFilter{

    public void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain) {
        //做自己的事情
        System.out.println("one之前的事情");
        //找管理者 让管理者找下一个人  放行
        chain.doFilter(request,response);
        System.out.println("one之后的事情");
    }
}
