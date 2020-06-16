package com.controller;

import com.model.City;
import com.service.CityService;
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
import java.util.ArrayList;
import java.util.List;


@WebServlet("cities/*")
public class CitiesServlet extends HttpServlet {

    @Inject
    private ServletContext context;

    @Inject
    private CityService service;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<City> route = new ArrayList<>();
        SessionUtils.setAttribute(request,"route", route);
        if (SessionUtils.getAttribute(request,"user") != null) {

            //TODO  This was used to fetch all cities and use further in home.jsp. Now cities are fetched in home.html
            //List<City> cities = service.getAll();
            //request.setAttribute("cities", cities);

            context.getRequestDispatcher("/static/home.html").forward(request, response);

        } else
            response.sendRedirect("/login?redirect_uri=http://localhost:8080/cities");
//            context.getRequestDispatcher("/auth/account/login.jsp").forward(request, response);
    }
}
