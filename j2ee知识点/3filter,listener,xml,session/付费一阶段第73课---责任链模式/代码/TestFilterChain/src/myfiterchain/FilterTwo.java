package myfiterchain;

public class FilterTwo extends HttpFilter {

    public void doFilter(FilterChain chain) {
        System.out.println("two回答问题");
        chain.doFilter();
    }
}
