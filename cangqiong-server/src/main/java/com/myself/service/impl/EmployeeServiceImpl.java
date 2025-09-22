package com.myself.service.impl;

import com.myself.mapper.EmployeeMapper;
import com.myself.service.EmployeeService;
import constant.JwtConstant;
import constant.MessageConstant;
import dto.EmployeeLoginDTO;
import entity.Employee;
import exception.AccountNotFoundException;
import exception.PasswordErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import property.JwtProperty;
import util.JwtUtil;
import vo.EmployeeLoginVO;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private JwtProperty jwtProperty;

    @Override
    public EmployeeLoginVO getByName(EmployeeLoginDTO employeeLoginDTO) {
        log.info("EmployeeServiceImpl开始执行:{}",employeeLoginDTO);

        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        Employee employee = employeeMapper.getByName(username);

        if (employee == null) {
            log.info("没找到用户");
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // md5加密验证
        String passwordMD5 = DigestUtils.md5DigestAsHex((password).getBytes());

        if (!passwordMD5.equals(employee.getPassword())) {
            log.info("密码错误");
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

//        生成jwt令牌
        Map<String ,Object> map = new HashMap<>();
        map.put(JwtConstant.EMP_ID,employee.getId());
//        String jwt = JwtUtil.createJWT(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminExpireTime(), map);
        String jwt = JwtUtil.createJWT(employee.getUsername(), jwtProperty.getAdminExpireTime(), map);

        EmployeeLoginVO employeeLoginVO = new EmployeeLoginVO();
        employeeLoginVO.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .name(employee.getName())
                .token(jwt)
                .build();

        return employeeLoginVO;
    }
}
