package com.axis.onion.rest;

import com.axis.onion.exception.BusinessException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingyuan on 2018/10/22.
 */
    @Path("/entry-point")
public class EntryPoint {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> test() {
        throw new BusinessException("00001","qingyuan");
//        Map<String, Object> result = new HashMap<>();
//        result.put("msg", "test");
//        return result;
    }
}
