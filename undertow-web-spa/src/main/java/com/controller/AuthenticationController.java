package com.controller;

import com.model.User;
import com.service.AuthenticationService;
import com.web.json.JsonResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @POST
    @Path("authenticate")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(hidden = true)
    public JsonResponse authenticate(@QueryParam("redirect_uri") String redirectUri, User profileInput) {
        String username = profileInput.getUsername();
        String password = profileInput.getPassword();

        User user = service.authenticate(username, password);

        if (user != null) {
            final String url = redirectUri;
            return new JsonResponse()
                    .with("status", "Redirect")
                    .with("redirectUrl", url).done();
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("/cities");
        } else
            return new JsonResponse()
                    .with("status", "Error")
                    .with("error", "The username or password you entered is incorrect.").done();
//            context.getRequestDispatcher("/auth/account/error.jsp").forward(request, response);


    }
}
