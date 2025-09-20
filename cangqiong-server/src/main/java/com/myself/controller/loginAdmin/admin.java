package com.myself.controller.loginAdmin;

import com.myself.service.EmployeeService;
import dto.EmployeeLoginDTO;
import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

@RestController("/admin/employee")
@Slf4j
public class admin {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public Result loginAndCheck(@RequestBody EmployeeLoginDTO employeeLoginDTO){

        Employee employee =  employeeService.getByName(employeeLoginDTO.getName());
        return null;
    }
}
