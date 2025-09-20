package com.myself.mapper;

import entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee getByName(String name);

}
