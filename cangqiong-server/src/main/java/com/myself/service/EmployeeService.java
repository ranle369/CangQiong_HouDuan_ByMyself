package com.myself.service;

import dto.EmployeeInsertDTO;
import dto.EmployeeLoginDTO;
import entity.Employee;
import vo.EmployeeLoginVO;


public interface EmployeeService {
    EmployeeLoginVO getByName(EmployeeLoginDTO employeeLoginDTO);

    void insertEmployee(EmployeeInsertDTO employeeInsertDTO);
}
