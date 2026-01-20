package com.example.studentportalee.filter;


import com.example.studentportalee.model.User;
import com.example.studentportalee.model.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/changeStudent","/deleteStudent","/changeCourse","/deleteCourse"})
public class AdminAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if(servletRequest instanceof HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if(user != null && user.getRole() == UserRole.ADMIN){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            ((HttpServletResponse)servletResponse).sendRedirect("/home");
        }
    }
    }
}
