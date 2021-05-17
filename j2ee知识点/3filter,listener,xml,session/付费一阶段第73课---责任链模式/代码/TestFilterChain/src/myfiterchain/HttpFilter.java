package myfiterchain;

public abstract class HttpFilter implements Filter {

    public abstract void doFilter(FilterChain chain);
}
