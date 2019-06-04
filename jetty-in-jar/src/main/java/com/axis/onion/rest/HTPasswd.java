package com.axis.onion.rest;

import cc.kebei.utils.StringUtils;
import com.axis.onion.exception.BusinessException;
import com.axis.onion.service.HTPasswdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingyuan on 2018/10/22.
 */
@Path("/htpasswd")
public class HTPasswd {

    private static Logger log = LoggerFactory.getLogger(HTPasswd.class);

    @Autowired
    private HTPasswdService htPasswdService;

    @GET
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("name") String name, @QueryParam("token") String password) {
        String ret = htPasswdService.updatePassword(name, password);
        Map<String, Object> result = new HashMap<>();
        if (!StringUtils.isNullOrEmpty(ret)) {
            return Response.serverError().build();
        }
        result.put("msg", "success");
        return Response.ok(result).build();
    }
}
