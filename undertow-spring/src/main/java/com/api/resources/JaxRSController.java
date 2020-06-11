package com.api.resources;

import com.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/")
public class JaxRSController {

    @Autowired
    private HelloService helloService;

    @GET
    @Path("helloMessage")
    public Response sayHello() {

        String output = "Hello world!";
        return Response.ok(output).status(200).build();
    }

    @GET
    @Path("welcome")
    public String welcome() {

        String message = helloService.welcome();
        return message;
    }
}
