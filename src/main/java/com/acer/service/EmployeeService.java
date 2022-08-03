package com.acer.service;

import com.acer.model.Employee;

import java.util.List;


/**
 * @author acer
 */
public interface EmployeeService{

    /**
     * 分页查询
     * @author acer
     * @date 10:31 2022/7/28
     * @param page 显示页数
     * @param pageSize 每页显示条数
     * @param name 要查询的员工姓名
     * @return java.util.List<com.acer.model.Employee>
    **/
    List<Employee> queryLimit(int page,int pageSize,String name);


    /**
     * 禁用或开启用户功能
     * @author acer
     * @date 14:30 2022/7/29
     * @param employee 要修改的用户id,修改的状态
     * @return int
    **/
    int updateStatus(Employee employee);

    /**
     * 修改功能
     * @author acer
     * @date 14:30 2022/7/29
     * @param employee 修改数据
     * @return int
     **/
    int updateValue(Employee employee);

    /**
     * 根据id查询对应数据
     * @author acer
     * @date 16:35 2022/7/29
     * @param id 员工id
     * @return com.acer.model.Employee
    **/
    Employee queryById(Long id);

    /**
     * 登录用户查询
     * @author acer
     * @date 10:06 2022/8/2
     * @param employee 要查询的账号
     * @return com.acer.model.Employee
    **/
    Employee loginQuery(Employee employee);

    /**
     * 新增数据
     * @author acer
     * @date 10:13 2022/8/2
     * @param employee 要新增数据
     * @return int
    **/
    int save(Employee employee);

}
