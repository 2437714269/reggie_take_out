package com.acer.controller;

import com.acer.common.R;
import com.acer.model.Employee;
import com.acer.model.dto.PageDto;
import com.acer.model.vo.PageVo;
import com.acer.service.EmployeeService;
import com.acer.utils.CheckParamUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 员工管理：相关功能
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
    private final EmployeeService employeeService;

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
        if (CheckParamUtils.isNullOrEmpty(employee)) {
            return R.error("字段为空");
        }
        //账号的验证
        if (CheckParamUtils.isNullOrEmpty(employeeService.loginQuery(employee))){
            return R.error("用户名不存在");
        }
        //2.将password进行MD5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //3.根据userName获取用户数据（前提userName是唯一不重复的值）
        Employee emp = employeeService.loginQuery(employee);
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


    /**
     * 新增员工数据
     * @author acer
     * @date 17:33 2022/7/27
     * @param request 返回
     * @param employee 获取添加员工的数据
     * @return com.acer.common.R<java.lang.String>
    **/
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee){

        log.info("新增员工数据：{}",employee.toString());

        //1.初始密码123456，利用DigestUtils对初始密码进行MD5加密处理
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        employee.setPassword(password);
        // 2.获取当前登录用户的Id
        long createUserId = (long)request.getSession().getAttribute("employee");
        // 3.获取创建时间和修改时间
        // employee.setCreateTime(LocalDateTime.now());
        // employee.setUpdateTime(LocalDateTime.now());
        // // 给创建人和修改人进行赋值
        // employee.setCreateUser(createUserId);
        // employee.setUpdateUser(createUserId);
        // employee.setStatus(1);

        // 插入数据
        employeeService.save(employee);
        return R.success("新增员工成功");
    }

    /**
     * 员工管理查询和搜索框员工查询
     * @author acer
     * @date 16:17 2022/7/28
     * @param pageDto 分页查询的条件数据
     * @return com.acer.common.R<com.acer.model.vo.PageVo>
    **/
    @GetMapping("/page")
    public R<PageVo> page(PageDto pageDto){
        log.info("分页查询开始,{}",pageDto.toString());
        List<Employee> employees = employeeService.queryLimit(pageDto.getPage(), pageDto.getPageSize(),pageDto.getName());
        return R.success(new PageVo(employees,employees.size(),employees.size()));
    }


    /**
     * 编辑修改功能
     * @author acer
     * @date 11:37 2022/7/29
     * @param id 用户id
     * @return com.acer.common.R<java.lang.String>
    **/
    @GetMapping("/{id}")
    public R<Employee> gitById(@PathVariable Long id){
        log.info("数据类型为，{}",id.getClass());
        log.info("要修改的用户id,{}",id);
        //将id存到Session中
        Employee employee = employeeService.queryById(id);
        if (employee != null){
            return R.success(employee);
        }
        return R.error("没有查询到对应员工信息");
    }

    /**
     * 修改功能 和 禁用或开启用户功能， 共用一个方法
     * @param employee 要修改的值
     */
    @PutMapping
    public R<String> disable(@RequestBody Employee employee){
        log.info(employee.toString());

        //判断employee的参数判断执行什么操作
        if(employee.getName() == null && employee.getPassword() == null && employee.getUsername() == null){
            int value = employeeService.updateStatus(employee);
            if(value == 0){
                return R.success("员工状态修改失败");
            }
            return R.success("员工状态修改成功");
        }

        // 修改员工信息
        int value = employeeService.updateValue(employee);
        if (value == 0){
            R.success("员工信息修改失败");
        }

        return R.success("员工信息修改成功");
    }












































}
