package com.hugcode.managementsystem.common;

public class AppException extends RuntimeException{
    private Integer code=500;
    private String message="服务器异常";

    public AppException(ResponseStatus responseStatus) {
        super();
        this.code = responseStatus.getCode();
        this.message = responseStatus.getDescription();
    }
    public AppException(Integer code,String message){
        super();
        this.code=code;
        this.message=message;
    }
    private AppException() {
        super();
    }
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
