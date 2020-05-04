package com.route.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouteController {

    @GetMapping({"/", "/helloMessage"})
    public String hello(Model model, HttpServletRequest request) {
        model.addAttribute("name", request.getParameter("name"));
        String path = request.getContextPath();
        model.addAttribute("serverPath", path);
        return "hello";
    }

    @GetMapping(value = "/hello")
    public String promise() {
        System.out.println("????????????????????");
        return "test";
    }
}
