package com.myself.service;

import dto.EmployeeLoginDTO;
import entity.Employee;


public interface EmployeeService {
    Employee getByName(EmployeeLoginDTO employeeLoginDTO);
}
