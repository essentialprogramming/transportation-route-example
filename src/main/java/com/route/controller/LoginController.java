package com.route.controller;

import com.route.model.User;
import com.route.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private AuthenticationService service;

    @Autowired
    public LoginController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/authenticate")
    public String authenticate(HttpServletRequest request, HttpSession session) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = service.authenticate(username, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/cities";
        } else return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.invalidate();
        return "login";
    }
}
