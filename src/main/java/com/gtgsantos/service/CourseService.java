package com.gtgsantos.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/course")
public class CourseService {

    
    @GET
    //@Path("/{param}")
    public Response getCourse() { //(@PathParam("param") String msg) {
 
        
        //Product prod = repository.findByName("nono");
        
 
        return Response.status(200).entity("msg!!!").build();
 
    }
}
