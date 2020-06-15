package com.controller;

import com.model.City;
import com.service.CityService;
import com.web.json.JsonResponse;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class CitiesController {

    @Autowired
    private CityService service;

    @GET
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> cities() {
        return service.getAll();
    }


}
