package com.myself.controller.loginAdmin;

import com.github.pagehelper.PageHelper;
import dto.EmployeeInsertDTO;
import dto.EmployeePageDTO;
import org.springframework.beans.support.PagedListHolder;
import result.Result;
import com.myself.service.EmployeeService;
import dto.EmployeeLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ThreadLocalUtil;
import vo.EmployeeLoginVO;
import vo.EmployeePageVO;

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

    @GetMapping("/page")
    public Result<EmployeePageVO> showPage(EmployeePageDTO employeePageDTO){
        log.info("员工分页查询{}",employeePageDTO);
        PageHelper.startPage(employeePageDTO.getPage(), employeePageDTO.getPageSize());
        EmployeePageVO employeePageVO = employeeService.showPage(employeePageDTO);

        return Result.success(employeePageVO);
    }

}
