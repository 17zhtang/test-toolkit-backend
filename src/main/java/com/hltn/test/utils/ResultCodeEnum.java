package com.hltn.test.utils;


public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    ACCOUNT_ERROR(501,"account error"),
    PASSWORD_ERROR(503,"password error"),
    NOT_LOGIN(504,"not Login"),
    ACCOUNT_EXIST(505,"account already exists");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}

