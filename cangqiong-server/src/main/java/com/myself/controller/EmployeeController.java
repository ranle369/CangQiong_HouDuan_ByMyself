package com.myself.controller;

import result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class EmployeeController {

    @RequestMapping(path="/get", method= RequestMethod.GET)
    public Result<String> test(){
        log.info("test");
        return null;
    }

}
