package com.acer.mapper;

import com.acer.model.Category;

import java.util.List;

/**
 * @author acer
 */
public interface CategoryMapper {

    /**
     * 初始化数据，分页查询
     * @author acer
     * @date 14:56 2022/8/2
     * @param page 要显示的页数
     * @param pageSize 每页显示的数据条数
     * @return java.util.List<com.acer.model.Category>
    **/
    List<Category> queryCategory(int page,int pageSize);

    /**
     * 新增菜品分类
     * @author acer
     * @date 9:44 2022/8/3
     * @param category 要添加的菜品分类
     * @return int
    **/
    int query(Category category);
}
