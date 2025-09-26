package com.myself.controller.loginAdmin;

import dto.EmployeeInsertDTO;
import result.Result;
import com.myself.service.EmployeeService;
import dto.EmployeeLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ThreadLocalUtil;
import vo.EmployeeLoginVO;

@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class AdminLoginController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result<EmployeeLoginVO> loginAndCheck(@RequestBody EmployeeLoginDTO employeeLoginDTO){
        log.info("登录信息：{}",employeeLoginDTO);

        EmployeeLoginVO employeeLoginVO =  employeeService.getByName(employeeLoginDTO);

        return Result.success(employeeLoginVO);
    }

    @PostMapping("/logout")
    public Result logoutEmployee(){
        return Result.success();
    }

    @PostMapping()
    public Result<String> insertEmployee(@RequestBody EmployeeInsertDTO employeeInsertDTO){
        log.info("新增员工{}",employeeInsertDTO);
        employeeService.insertEmployee(employeeInsertDTO);
        ThreadLocalUtil.clear();
        return Result.success("success");
    }
}
