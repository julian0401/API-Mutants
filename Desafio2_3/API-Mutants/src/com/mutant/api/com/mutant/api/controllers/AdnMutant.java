package com.mutant.api.controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mutant.api.model.ADN;
import com.mutant.api.model.RequestMutant;
import com.mutant.api.model.ResponseError;

@Path("/mutant")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdnMutant extends Controller{
	    public AdnMutant() throws SQLException, ClassNotFoundException, IOException {
	        readConfig();
	        InitializeDependencies();
	    }

	    @POST
	    public Response IsMutant(RequestMutant request) {
	        try {
	            if (bussiness.isMutant(new ADN(request.getDna()))) {
	                return Response.status(200).build();
	            } else {
	                return Response.status(403).build();
	            }
	        } catch (Exception e) {
	        	ResponseError response = new ResponseError();
	            response.setMessage(e.getMessage());
	            return Response.status(500).entity(response).build();
	        }
	    }
	}