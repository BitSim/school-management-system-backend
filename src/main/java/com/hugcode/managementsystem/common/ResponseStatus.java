package com.hugcode.managementsystem.common;



public enum ResponseStatus {

    SUCCESS(200,"success"),
    REQUEST_PARAM_ERROR(400,"请求参数错误"),

    USER_NOT_EXIST(1001,"用户不存在"),
    USER_PASSWORD_OR_USERNAME_ERROR(1002,"用户名或密码错误"),
    USER_ALREADY_EXIST(1003,"用户已存在"),
    USER_NOT_LOGIN(1004,"用户未登录"),
    USER_NOT_AUTHORIZED(1005,"用户未授权"),
    COURSE_NOT_EXIST(2006,"课程不存在"),
    COURSE_EXIST(2007,"课程已存在"),
    STUDENT_OR_COURSE_NOT_EXIST(3001,"学生或课程不存在"),
    TEACHER_OR_COURSE_NOT_EXIST(3002,"教师或课程不存在"),
    TEACHER_NOT_EXIST(3003,"教师不存在"),
    TEACHER_ALREADY_EXIST(3004,"教师已存在"),

    ERROR(400,"error"),
    ;
    private final Integer code;
    private final String description;
    private ResponseStatus(Integer code,String description){
        this.code=code;
        this.description=description;
    }
    public Integer getCode(){
        return code;
    }
    public String getDescription(){
        return description;
    }
}
