package com.acer.service.impl;

import com.acer.mapper.EmployeeMapper;
import com.acer.model.Employee;
import com.acer.model.dto.PageDto;
import com.acer.service.EmployeeService;
import com.acer.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author acer
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    /**
     * 分页查询
     * @author acer
     * @date 10:31 2022/7/28
     * @param page 显示页数
     * @param pageSize 每页显示条数
     * @return java.util.List<com.acer.model.Employee>
     **/
    @Override
    public List<Employee> queryLimit(int page, int pageSize,String name) {
        //调用分页工具
        PageDto pageDto = PageUtils.countPage(page, pageSize,name);
        return employeeMapper.queryLimit(pageDto.getPage(),pageDto.getPageSize(),name);
    }

    /**
     * 修改功能 和 禁用或开启用户功能， 共用一个方法
     * @author acer
     * @date 14:30 2022/7/29
     * @param employee 要修改的用户id,修改的状态
     * @return int
     **/
    @Override
    public int updateStatus(Employee employee) {
        // 判断如果status有值就执行，禁用功能，否则执行修改功能
        log.info("disableDTo的数据为：{}",employee.toString());
        int StatusValue = employeeMapper.updateStatus(employee);
        if (StatusValue == 0){
            return 0;
        }
        return 1;
    }
    /**
     * 修改功能 和 禁用或开启用户功能， 共用一个方法
     * @author acer
     * @date 14:30 2022/7/29
     * @param employee 要修改的用户id,修改的状态
     * @return int
     **/
    @Override
    public int updateValue(Employee employee) {
        //修改功能
        int updateValue = employeeMapper.update(employee);
        if (updateValue == 0){
            return 0;
        }
        return 1;
    }

    /**
     * 根据id查询对应数据
     * @author acer
     * @date 16:35 2022/7/29
     * @param id 员工id
     * @return com.acer.model.Employee
     **/
    @Override
    public Employee queryById(Long id) {
        // 调用mapper接口查询员工数据
        return employeeMapper.queryById(id);

    }

    /**
     * 登录用户查询
     * @author acer
     * @date 10:06 2022/8/2
     * @param employee 要查询的账号
     * @return com.acer.model.Employee
     **/
    @Override
    public Employee loginQuery(Employee employee) {
        return employeeMapper.loginQuery(employee);
    }

    /**
     * 新增数据
     * @author acer
     * @date 10:13 2022/8/2
     * @param employee 要新增数据
     * @return int
     **/
    @Override
    public int save(Employee employee) {
        return employeeMapper.save(employee);
    }

}
