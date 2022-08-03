package com.acer.controller;

import com.acer.common.R;
import com.acer.model.Category;
import com.acer.model.dto.CategoryDto;
import com.acer.model.dto.PageDto;
import com.acer.model.vo.PageVo;
import com.acer.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类管理，相关功能
 * @author acer
 */
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    /**
     * service层支持
     */
    private final CategoryService categoryService;


    /**
     * 初始化分类管理页面
     * @author acer
     * @date 8:55 2022/8/3
     * @param pageDto 分页查询的条件
     * @return com.acer.common.R<com.acer.model.vo.PageVo>
    **/
    @GetMapping("/page")
    public R<PageVo> page(PageDto pageDto){
        List<Category> categoryList = categoryService.queryCategory(pageDto.getPage(),pageDto.getPageSize());
        return R.success(new PageVo(categoryList,categoryList.size(),categoryList.size()));
    }

    @PostMapping
    public void query(@RequestBody CategoryDto categoryDto){
        categoryService.query(categoryDto);
    }

}
