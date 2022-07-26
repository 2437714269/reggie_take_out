package com.acer.mapper;

import com.acer.model.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 超哥
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
