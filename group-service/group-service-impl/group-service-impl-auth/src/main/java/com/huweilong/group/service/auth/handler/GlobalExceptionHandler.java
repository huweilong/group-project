package com.huweilong.group.service.auth.handler;

import com.huweilong.group.service.dto.basics.global.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author Alex
 */
@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {
    /**
     * Exception
     * @param e 异常信息
     * @return 返回结果
     */
    @ExceptionHandler(Exception.class)
    public Results runtimeExceptionHandler(Exception e) {
        // 打印异常信息到控制台
        e.printStackTrace();
        log.error("请求出现异常,异常信息为: {}", e.getMessage());
        // 使用公共的结果类封装返回结果
        return Results.ERROR(e.getMessage());
    }

    /**
     * MethodArgumentNotValidException
     * @param e 异常信息
     * @return 返回结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Results handleBindException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        log.error("参数校验异常:{}({})", fieldError.getDefaultMessage(), fieldError.getField());
        return Results.ERROR(fieldError.getDefaultMessage());
    }

    /**
     * BindException
     * @param e 异常信息
     * @return 返回结果
     */
    @ExceptionHandler(BindException.class)
    public Results handleBindException(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        log.error("参数校验异常:{}({})", fieldError.getDefaultMessage(), fieldError.getField());
        return Results.ERROR(fieldError.getDefaultMessage());
    }
}
