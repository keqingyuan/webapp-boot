package com.axis.onion.exception;

/**
 * Created by qingyuan on 2018/10/23.
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8627838232253690816L;

    private String code;

    private Object[] args;

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String code, Object... args) {
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
}
