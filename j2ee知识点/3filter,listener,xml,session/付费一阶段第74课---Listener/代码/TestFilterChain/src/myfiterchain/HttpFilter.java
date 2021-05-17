package myfiterchain;

public abstract class HttpFilter extends GenericFilter {

    public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain);
}
