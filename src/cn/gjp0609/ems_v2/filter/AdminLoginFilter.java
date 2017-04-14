package cn.gjp0609.ems_v2.filter;


import cn.gjp0609.ems_v2.entity.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gjp06 on 17.4.4.
 */
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin == null) response.sendRedirect(request.getContextPath() + "/login.jsp");
        else chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
