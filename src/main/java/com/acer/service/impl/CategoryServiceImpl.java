package com.acer.service.impl;

import com.acer.mapper.CategoryMapper;
import com.acer.model.Category;
import com.acer.model.dto.CategoryDto;
import com.acer.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author acer
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    /**
     * dao层支持
     */
    private final CategoryMapper categoryMapper;

    /**
     * 菜品分离管理
     * @author acer
     * @date 11:28 2022/8/2
     * @param page 起始页数
     * @param pageSize 每页显示的数据条数
     * @return java.util.List<com.acer.model.Category>
     **/
    @Override
    public List<Category> queryCategory(int page, int pageSize) {
        return categoryMapper.queryCategory(page,pageSize);
    }

    /**
     * 新增菜品分类
     * @author acer
     * @date 9:30 2022/8/3
     * @param categoryDto 新增的菜品
     * @return int
     **/
    @Override
    public int query(CategoryDto categoryDto) {
        //dto转实体类
        Category category = Category.builder()
                .type(categoryDto.getType())
                .name(categoryDto.getName())
                .sort(categoryDto.getSort())
                .build();
        return categoryMapper.query(category);
    }
}
