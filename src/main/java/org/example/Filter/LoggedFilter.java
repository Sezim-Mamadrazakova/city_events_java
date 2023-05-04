package org.example.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter("/user/*")

public class LoggedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (httpServletRequest.getAttribute("loggedUser") == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "error?errorMessage=notLogged");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
