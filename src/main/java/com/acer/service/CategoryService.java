package com.acer.service;

import com.acer.model.Category;
import com.acer.model.dto.CategoryDto;

import java.util.List;

/**
 * @author acer
 */
public interface CategoryService {

    /**
     * 菜品分离管理
     * @author acer
     * @date 11:28 2022/8/2
     * @param page 起始页数
     * @param pageSize 每页显示的数据条数
     * @return java.util.List<com.acer.model.Category>
    **/
    List<Category> queryCategory(int page,int pageSize);

    /**
     * 新增菜品分类
     * @author acer
     * @date 9:30 2022/8/3
     * @param categoryDto 新增的菜品
     * @return int
    **/
    int query(CategoryDto categoryDto);
}
