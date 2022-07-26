package com.acer.service.impl;

import com.acer.model.Employee;
import com.acer.mapper.EmployeeMapper;
import com.acer.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName EmployeeServiceImpl
 * @Description :
 * @Author :
 * @Date 2022/7/26 10:58
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
