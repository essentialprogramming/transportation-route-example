package com.controller;


import com.model.City;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class NeighboursController {

    @Autowired
    private CityService service;

    @GET
    @Path("/neighbours")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(@QueryParam("cname") String cname) {
        return service.getNeighbours(cname);
    }
}
