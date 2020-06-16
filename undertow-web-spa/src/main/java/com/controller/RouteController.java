package com.controller;

import com.model.City;
import com.service.CityService;
import com.util.web.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/city")
public class RouteController {

    @Autowired
    private CityService service;

    @Context
    private HttpServletRequest httpRequest;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public City findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public City addCity(City city) {
        return service.addCity(city);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/route")
    public List<City> finalRoute(){
        return SessionUtils.getAttribute(httpRequest, "route");
    }

}
