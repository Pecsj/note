package myfiterchain;

public class FilterFour extends HttpFilter {

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        System.out.println("four之前的事情");
        chain.doFilter(request,response);
        System.out.println("four之后的事情");
    }
}
