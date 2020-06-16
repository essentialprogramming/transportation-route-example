package com.controller;

import com.model.User;
import com.service.AuthenticationService;
import com.util.web.SessionUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("authenticate/*")
public class AuthenticationServlet extends HttpServlet {

    @Inject
    private AuthenticationService service;

    @Inject
    private ServletContext context;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = service.authenticate(username, password);

        if (user != null) {
            SessionUtils.setAttribute(request,"user", user);
            response.sendRedirect("/cities");
        } else
            context.getRequestDispatcher("/auth/account/error.jsp").forward(request, response);
    }

}
