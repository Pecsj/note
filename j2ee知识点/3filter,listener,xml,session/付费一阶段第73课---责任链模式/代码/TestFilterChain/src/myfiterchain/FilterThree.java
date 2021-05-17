package myfiterchain;

public class FilterThree extends HttpFilter {

    public void doFilter(FilterChain chain) {
        System.out.println("three回答问题");
        chain.doFilter();
    }
}
