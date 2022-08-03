package com.acer.mapper;

import com.acer.model.Employee;

import java.util.List;

/**
 * @author 超哥
 */

public interface EmployeeMapper{

    /**
     * 初始化查询数据
     * @author acer
     * @date 9:48 2022/7/28
     * @param page 要显示第几页
     * @param pageSize 每页显示的页数
     * @param name 用户姓名
     * @return java.util.List<com.acer.model.Employee>
    **/
    List<Employee> queryLimit(int page,int pageSize,String name);


    /**
     * 修改用户状态
     * @author acer
     * @date 14:40 2022/7/29
     * @param employee 要修改的用户id,修改的状态
     * @return int
    **/
    int updateStatus(Employee employee);

    /**
     * 根据id查询对应数据
     * @author acer
     * @date 16:35 2022/7/29
     * @param id 员工id
     * @return com.acer.model.Employee
     **/
    Employee queryById(Long id);

    /**
     * 修改用户数据
     * @author acer
     * @date 10:45 2022/8/2
     * @param employee 要修改的数据据
     * @return int
    **/
    int update(Employee employee);

    /**
     * 登录账号验证
     * @author acer
     * @date 10:46 2022/8/2
     * @param employee  账号和密码
     * @return com.acer.model.Employee
    **/
    Employee loginQuery(Employee employee);

    /**
     * 新增员工
     * @author acer
     * @date 10:51 2022/8/2
     * @param employee 新增数据
     * @return int
    **/
    int save(Employee employee);












}
