package com.axis.onion.exception;

/**
 * Created by qingyuan on 2018/10/23.
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8627838232253690816L;

    public BusinessException(String code) {
        super(code);
    }

}
