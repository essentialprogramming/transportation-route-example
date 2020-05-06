package com.route.controller;


import com.route.entities.CityEntity;
import com.route.model.City;
import com.route.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RouteController {

    private CityService service;

    @Autowired
    public RouteController(CityService service) {
        this.service = service;
    }

    @PostMapping("/city")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return new ResponseEntity<>(service.addCity(city), HttpStatus.OK);
    }

    @GetMapping({"/", "/cities"})
    public String getCities(HttpSession session, Model model) {
        List<City> route = new ArrayList<>();
        session.setAttribute("route", route);
        if (session.getAttribute("user") != null) {
            List<City> cities = service.getAll();
            model.addAttribute("cities", cities);
            return "home";
        } else return "redirect:/login";
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> findById(@PathVariable("id") int id) {
        City city = service.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/neighbours")
    public String getNeighbours(Model model, HttpServletRequest request) {
        String cityName = request.getParameter("cname");
        City city = service.findByName(cityName);

        List<City> route = (List<City>) request.getSession().getAttribute("route");
        route.add(city);
        request.getSession().setAttribute("route", route);

        List<City> neighbours = service.getNeighbours(cityName);
        model.addAttribute("neighbours", neighbours);
        return "neighboursMap";
    }

    @GetMapping("/route")
    public String getFinalRoute(Model model, HttpSession session) {
        List<City> route = (List<City>) session.getAttribute("route");
        model.addAttribute("route", route);
        return "finalRoute";
    }

    @GetMapping("/undo")
    public String undo(Model model, HttpSession session) {
        List<City> route = (List<City>) session.getAttribute("route");
        route.remove(route.size() - 1);

        List<City> neighbours = service.getNeighbours(route.get(route.size() - 1).getName());
        model.addAttribute("neighbours", neighbours);
        return "neighboursMap";


    }
}
