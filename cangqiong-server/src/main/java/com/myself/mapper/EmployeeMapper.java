package com.myself.mapper;

import entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

//    @Select("select * from employee where username = #{username}")
    Employee getByName(String username);

    void insertEmployee(Employee employee);
}
