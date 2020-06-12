package com.controller;

import com.model.City;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/city")
public class RouteController {

    @Autowired
    private CityService service;

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

}
