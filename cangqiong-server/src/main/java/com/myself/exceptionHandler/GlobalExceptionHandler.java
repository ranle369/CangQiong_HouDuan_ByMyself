package com.myself.exceptionHandler;

import constant.MessageConstant;
import result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result<String> handleException(Exception e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> handleException(SQLIntegrityConstraintViolationException e) {

        String message = e.getMessage();

        if (message.contains("Duplicate entry")) {
            String[] split = message.split("");
            return Result.error(split[2]+ MessageConstant.USERNAME_IS_EXIST);
        }else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }

    }

}
