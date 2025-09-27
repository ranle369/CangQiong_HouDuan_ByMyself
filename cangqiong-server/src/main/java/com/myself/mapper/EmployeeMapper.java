package com.myself.mapper;

import com.github.pagehelper.Page;
import dto.EmployeePageDTO;
import entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

//    @Select("select * from employee where username = #{username}")
    Employee getByName(String username);

    void insertEmployee(Employee employee);

    Page<Employee> getPageHelperPara(EmployeePageDTO  employeePageDTO);
}
