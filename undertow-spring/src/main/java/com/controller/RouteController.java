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
    public ResponseEntity<City> findById(@PathParam("id") int id) {
        City city = service.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<City> addCity(City city) {
        return new ResponseEntity<>(service.addCity(city), HttpStatus.OK);
    }

}
