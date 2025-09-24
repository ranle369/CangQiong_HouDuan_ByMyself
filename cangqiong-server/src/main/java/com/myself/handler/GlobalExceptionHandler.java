package com.myself.handler;

import result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result<String> handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}
