package myfiterchain;

public class FilterTwo extends HttpFilter {

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        System.out.println("two之前的事情");
        chain.doFilter(request,response);
        System.out.println("two之后的事情");
    }
}
