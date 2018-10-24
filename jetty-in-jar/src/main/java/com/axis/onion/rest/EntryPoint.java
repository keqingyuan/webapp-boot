package com.axis.onion.rest;

import com.axis.onion.exception.BusinessException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by qingyuan on 2018/10/22.
 */
@Path("/entry-point")
public class EntryPoint {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        throw new BusinessException("nihao");
        //return "Test";
    }
}
