package com.route.controller;


import com.route.model.City;
import com.route.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouteController {

    private CityService service;

    @Autowired
    public RouteController(CityService service) {
        this.service = service;
    }

    @GetMapping({"/", "/helloMessage"})
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
}
