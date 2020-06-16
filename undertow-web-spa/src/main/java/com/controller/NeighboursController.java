package com.controller;


import com.model.City;
import com.service.CityService;
import com.util.web.SessionUtils;
import com.web.json.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class NeighboursController {

    @Autowired
    private CityService service;

    @Inject
    private HttpServletRequest request;

    @GET
    @Path("/neighbours")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(@QueryParam("cname") String cname) {
        return service.getNeighbours(cname);
    }

    @POST
    @Path("/neighbours")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResponse addToRoute(@QueryParam("cname") String cityName) {
        City city = service.findByName(cityName);

        List<City> route = SessionUtils.getAttribute(request, "route");
        route.add(city);

        return new JsonResponse()
                .with("status", "Ok")
                .with("cname", city.getName())
                .done();
    }

    @DELETE
    @Path("/neighbours")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResponse removeFromRoute() {

        List<City> route = SessionUtils.getAttribute(request, "route");
        route.remove(route.size() - 1);

        String cityName = route.get(route.size() - 1).getName();

        return new JsonResponse()
                .with("status", "Ok")
                .with("cname", cityName)
                .done();
    }

}
