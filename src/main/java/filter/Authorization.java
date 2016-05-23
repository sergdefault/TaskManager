package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Цымбалюк Сергей on 18.05.2016.
 */
public class Authorization implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession==null){
            servletRequest.getRequestDispatcher("authorization/login.jsp").forward(servletRequest,servletResponse);
        }else filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
