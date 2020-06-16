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
import java.util.List;


@WebServlet("neighbours/*")
public class NeighboursServlet extends HttpServlet {

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

        String cityName = request.getParameter("cname");
        City city = service.findByName(cityName);

        List<City> route =  SessionUtils.getAttribute(request, "route");
        route.add(city);
        route.forEach(item -> System.out.println( item.getName()));

        SessionUtils.setAttribute(request,"route", route);

        context.getRequestDispatcher("/static/neighbours.html?cname= " + cityName).forward(request, response);

    }

}
