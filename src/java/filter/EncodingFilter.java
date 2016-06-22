package filter;

import javax.servlet.*;
import java.io.IOException;


public class EncodingFilter implements Filter {
    private FilterConfig filterConfig = null;
    private String encoding;



    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String currentEncoding=req.getCharacterEncoding();
        if(encoding!=null&&!encoding.equalsIgnoreCase(currentEncoding)){
            req.setCharacterEncoding(encoding);
            resp.setCharacterEncoding(encoding);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.encoding=config.getInitParameter("defaultEncoding");

    }

    public void destroy() {
    }

}
