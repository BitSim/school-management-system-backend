package com.hugcode.managementsystem.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseResult exceptionHandler(Exception e) {
        //这里先判断拦截到的Exception是不是我们自定义的异常类型
        if (e instanceof AppException appException) {
            return ResponseResult.error(appException.getCode(), appException.getMessage());
        }
        return ResponseResult.error(500, "服务器端异常");
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseResult handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        // 在这里你可以返回一个自定义的错误消息
        return ResponseResult.error(400, "请求参数错误");
    }
}
