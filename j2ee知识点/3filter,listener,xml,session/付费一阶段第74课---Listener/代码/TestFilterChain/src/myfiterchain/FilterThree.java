package myfiterchain;


public class FilterThree extends HttpFilter {

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        System.out.println("three之前的事情");
        chain.doFilter(request,response);
        System.out.println("three之后的事情");
    }
}
