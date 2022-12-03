package com.example.library.controller;

import com.example.library.model.BO.UserBO;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter", urlPatterns = {"/Users/*", "/UpdateBorrowed", "/SaveBorrowed", "/ListBorrowed",
        "/CreateBorrowed", "/AddBook", "/DeleteBook", "/EditBook", "/ManageBook", "/AddCategories",
        "/DeleteCategories", "/EditCategories", "/ManageCategories"})
public class RoleFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String username = (String) httpServletRequest.getSession().getAttribute("username");
        if(username != null)  {
            UserBO userBO = new UserBO();
            if(userBO.getUserByUsername(username).getRole().equals("MANAGE")) {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}
