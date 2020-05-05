package com.route.controller;


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
import java.util.List;

@Controller
public class RouteController {

    private CityService service;

    @Autowired
    public RouteController(CityService service) {
        this.service = service;
    }

    @GetMapping({"/helloMessage"})
    public String hello(Model model, HttpServletRequest request) {
        model.addAttribute("name", request.getParameter("name"));
        String path = request.getContextPath();
        return "hello";
    }

    @GetMapping(value = "/hello")
    public String promise() {
        return "test";
    }

    @PostMapping("/city")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return new ResponseEntity<>(service.addCity(city), HttpStatus.OK);
    }

    @GetMapping({"/", "/cities"})
    public String getCities(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
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
}
