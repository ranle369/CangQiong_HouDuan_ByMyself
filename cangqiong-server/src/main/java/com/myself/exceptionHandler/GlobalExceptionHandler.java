package com.myself.exceptionHandler;

import constant.MessageConstant;
import exception.DuplicateUsernameException;
import lombok.extern.slf4j.Slf4j;
import result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import util.ThreadLocalUtil;

import java.sql.SQLIntegrityConstraintViolationException;


@Slf4j
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
            ThreadLocalUtil.clear();
            return Result.error(split[2]+ MessageConstant.USERNAME_IS_EXIST);
        }else {
            ThreadLocalUtil.clear();
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }

    }

    @ExceptionHandler(DuplicateUsernameException.class)
    public Result<String> handleException(DuplicateUsernameException e) {
        log.info(e.getMessage());
        String message = e.getMessage();
        String[] split = message.split("");
        ThreadLocalUtil.clear();
        return Result.error(split[2]+ MessageConstant.USERNAME_IS_EXIST);
    }


}
