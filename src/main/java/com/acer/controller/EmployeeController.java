package com.acer.controller;

import com.acer.common.R;
import com.acer.model.Employee;
import com.acer.service.impl.EmployeeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author acer
 */
@Slf4j
@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {
    /**
     * EmployeeService层的支持
     */
    private final EmployeeServiceImpl employeeService;

    /**
     * 用户登录
     * @author acer
     * @date 17:13 2022/7/26
     * @param request 将用户id存到|Session中方便使用
     * @param employee DTO前端传过来的json数据，用RequestBody修饰
     * @return com.acer.common.R<com.acer.model.Employee>
    **/
    @PostMapping("/login")
    public R<Employee> loginEmploy(HttpServletRequest request, @RequestBody Employee employee){
        //1.判断userName和password是否为空

        //2.将password进行MD5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //3.根据userName获取用户数据（前提userName是唯一不重复的值）
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        //4.判断获取的数据是否为空
        if (emp == null){
            return R.error("用户登陆失败");
        }
        //5.判断密码是否与查询到的一样
        if (!emp.getPassword().equals(password)){
            return R.error("用户登陆失败");
        }
        //6.查看员工的状态，1为正常，0为该用户已被禁用
        if (emp.getStatus() == 0){
            return R.error("该用户已被禁用");
        }
        //7.将用户id存到Session中方便后续操作用户信息
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * 账户退出操作，本质删除Session中的数据
     * @author acer
     * @date 17:12 2022/7/26
     * @param request 删除Session中的数据
     * @return com.acer.common.R<java.lang.String>
     **/
    @PostMapping("logout")
    public R<String> logout(HttpServletRequest request){
        // 删除Session中的employee
        request.getSession().getAttribute("employee");
        return R.success("退出成功");
    }

















































}