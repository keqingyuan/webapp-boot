package com.axis.onion.exception;

import javax.ws.rs.core.Response;

/**
 * Created by qingyuan on 2018/10/23.
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8627838232253690816L;

    private String code;

    private Object[] args;

    private Response.Status status = Response.Status.BAD_REQUEST;

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(Response.Status status) {
        this.status = status;
    }

    public BusinessException(String code, Object... args) {
        this.code = code;
        this.args = args;
    }

    public BusinessException(Response.Status status, String code, Object... args) {
        this.status = status;
        this.code = code;
        this.args = args;
    }

    public BusinessException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public String getMessage() {
        try {
            return com.axis.onion.i18nBundle.getMessage(this.code, args);
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public String getCode() {
        return code;
    }

    public Response.Status getStatus() {
        return status;
    }
}
