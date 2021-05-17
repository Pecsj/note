package myfiterchain;

public interface FilterChain {

    void addFilter(Filter filter);
    void doFilter();
}
