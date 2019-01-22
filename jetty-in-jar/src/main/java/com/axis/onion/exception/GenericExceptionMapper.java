package com.axis.onion.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by qingyuan on 2018/10/23.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<com.axis.onion.exception.BusinessException> {

    @Override
    public Response toResponse(BusinessException ex) {

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new Error(ex.getCode(), ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

//    private Response.StatusType getStatusType(Throwable ex) {
//        if (ex instanceof WebApplicationException) {
//            return ((WebApplicationException) ex).getResponse().getStatusInfo();
//        } else {
//            return Response.Status.INTERNAL_SERVER_ERROR;
//        }
//    }
}
