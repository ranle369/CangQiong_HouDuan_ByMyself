package com.myself.service.impl;

import com.myself.mapper.EmployeeMapper;
import com.myself.service.EmployeeService;
import constant.MessageConstant;
import dto.EmployeeLoginDTO;
import entity.Employee;
import exception.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getByName(EmployeeLoginDTO employeeLoginDTO) {

        String username = employeeLoginDTO.getName();
        String password = employeeLoginDTO.getPassword();

        Employee employee = employeeMapper.getByName(username);

        if (employee == null) {
            log.info("没找到用户");
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        return employee;
    }
}
