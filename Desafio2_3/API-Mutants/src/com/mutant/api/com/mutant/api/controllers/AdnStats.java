package com.mutant.api.controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;


@Path("/stats")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdnStats extends Controller {
    public AdnStats() throws SQLException, ClassNotFoundException, IOException {
        readConfig();
        InitializeDependencies();
    }
	
    @GET
    public Response Stats() throws ClassNotFoundException, JSONException, SQLException {
        return Response.status(200).entity(bussiness.getStats()).build();
    }
}
