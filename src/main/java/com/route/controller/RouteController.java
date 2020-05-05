package com.route.controller;


import com.route.model.City;
import com.route.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping({"/", "/routes"})
    public ResponseEntity<List<City>> getCities(HttpSession session) {
        if (!(session.getAttribute("username") == null)) {
            List<City> cities = service.getAll();
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> findById(@PathVariable("id") int id) {
        City city = service.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
