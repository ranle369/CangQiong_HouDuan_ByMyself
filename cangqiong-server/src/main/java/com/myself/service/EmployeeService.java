package com.myself.service;

import dto.EmployeeLoginDTO;
import entity.Employee;
import vo.EmployeeLoginVO;


public interface EmployeeService {
    EmployeeLoginVO getByName(EmployeeLoginDTO employeeLoginDTO);
}
