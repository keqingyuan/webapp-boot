package com.axis.onion.exception;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by qingyuan on 2018/10/22.
 */
@JsonRootName(value = "error")
public class Error {

    private String code;
    private String msg;

    public Error(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
