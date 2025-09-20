package com.myself.service.impl;

import com.myself.mapper.EmployeeMapper;
import com.myself.service.EmployeeService;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getByName(String name) {
        Employee employee = employeeMapper.getByName(name);
        return employee;
    }
}
