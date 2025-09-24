package com.myself.service.impl;

import constant.JwtConstant;
import constant.MessageConstant;
import exception.AccountNotFoundException;
import exception.PasswordErrorException;
import com.myself.mapper.EmployeeMapper;
import property.JwtProperty;
import com.myself.service.EmployeeService;
import util.JwtUtil;
import dto.EmployeeLoginDTO;
import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
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

        //载荷里面放的员工ID
        map.put(JwtConstant.EMP_ID,employee.getId());

//        生成的jwt令牌就需要，密钥以及过期时间时间
        String jwt = JwtUtil.createJWT(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminExpireTime(), map);
//        String jwt = JwtUtil.createJWT(employee.getUsername(), jwtProperty.getAdminExpireTime(), map);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .name(employee.getName())
                .token(jwt)
                .build();



        return employeeLoginVO;
    }
}
