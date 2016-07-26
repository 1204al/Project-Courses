package filter;

import properties.Config;
import properties.Message;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andrey on 7/23/2016.
 */
@WebFilter(filterName = "SecurityFilter")
public class SecurityFilter implements Filter {
    private static final String ERROR = "error";
    private static final String PAGE = "page";

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        String url = ((HttpServletRequest) request).getRequestURI();
        System.out.println("url = " + url);
        if(url.equals("/")
                ||url.equals("/controller")
                ||url.equals("/jquery.min.js")
                ||url.equals("/bootstrap.css")
                ||url.equals("/main.css")
                ||url.equals("/bootstrap.min.js")
                ||url.equals("/favicon.ico")
                ){
            chain.doFilter(request, response);

        }else{
            session.setAttribute(ERROR, Message.getInstance().getProperty(Message.RANDOM_ERROR));
            session.setAttribute(PAGE, Config.ERROR_PAGE);
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
