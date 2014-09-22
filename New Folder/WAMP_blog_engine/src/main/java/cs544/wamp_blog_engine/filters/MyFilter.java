/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.filters;

import cs544.wamp_blog_engine.service.IUserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author priya
 */
public class MyFilter implements Filter {

    private IUserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        userService = context.getBean("userService", IUserService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest) request).getSession().getAttribute("loggedUser") == null) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) ((HttpServletRequest) request).getUserPrincipal();
            if (token != null) {
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) token.getPrincipal();
                ((HttpServletRequest) request).getSession().setAttribute("loggedUser", userService.getUserByUsername(user.getUsername()));
//            System.out.println("Inside Filter Logged User(from db):" + ((HttpServletRequest) request).getSession().getAttribute("loggedUser"));
//              System.out.println("Inside Filter Logged User(from request):" + user.getUsername());
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
