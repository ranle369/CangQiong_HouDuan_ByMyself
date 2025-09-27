package com.myself.service;

import dto.EmployeeInsertDTO;
import dto.EmployeeLoginDTO;
import dto.EmployeePageDTO;
import entity.Employee;
import vo.EmployeeLoginVO;
import vo.EmployeePageVO;


public interface EmployeeService {
    EmployeeLoginVO getByName(EmployeeLoginDTO employeeLoginDTO);

    void insertEmployee(EmployeeInsertDTO employeeInsertDTO);

    EmployeePageVO showPage(EmployeePageDTO employeePageDTO);
}
