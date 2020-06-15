package com.controller;

import com.model.City;
import com.service.CityService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("route/*")
public class RouteServlet extends HttpServlet {

    @Inject
    private ServletContext context;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<City> route = (List<City>) request.getSession().getAttribute("route");
        request.getSession().setAttribute("route", route);

        context.getRequestDispatcher("/static/finalRoute.html").forward(request, response);

    }
}
