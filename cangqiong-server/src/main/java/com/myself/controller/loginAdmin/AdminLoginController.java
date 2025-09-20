package com.myself.controller.loginAdmin;

import com.myself.service.EmployeeService;
import dto.EmployeeLoginDTO;
import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;

@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class AdminLoginController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result loginAndCheck(@RequestBody EmployeeLoginDTO employeeLoginDTO){
        log.info("登录信息：{}",employeeLoginDTO);

        Employee employee =  employeeService.getByName(employeeLoginDTO);

        if(employee == null){
            return Result.error("用户不存在");
        }
        return null;
    }
}
