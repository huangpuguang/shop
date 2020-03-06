package com.hazer.goods.controller;


import com.hazer.goods.entity.Result;
import com.hazer.goods.entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName BaseExceptionHandler
 * @Description 异常处理类
 * @Author Hazer
 * @Date 2020/3/6 17:17
 **/
@ControllerAdvice
public class BaseExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        log.error(e.getMessage(),e);
        return new Result(false, StatusCode.ERROR,e.getMessage());
}
}
