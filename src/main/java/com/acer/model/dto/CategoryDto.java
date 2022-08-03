package com.acer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author acer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {


    /**
     * 类型   1 菜品分类 2 套餐分类
     */
    private Integer type;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 顺序
     */
    private Integer sort;
}
