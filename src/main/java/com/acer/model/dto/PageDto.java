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
public class PageDto {

    /**
     * 要显示的页数
     */
    private int page;

    /**
     * 每页显示的条数
     */
    private int pageSize;

    /**
     * 查找员工的姓名
     */
    private String name;
}
