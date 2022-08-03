package com.acer.utils;

import com.acer.model.dto.PageDto;

/**
 * @author acer
 */
public class PageUtils {

    /**
     * 计算分页查询的起始索引值
     * @author acer
     * @date 9:45 2022/7/28
     * @param page 前端发送的
     * @param pageSize 每页显示的条数
     * @param name 查询的姓名
     * @return com.acer.model.dto.PageDto
    **/
    public static PageDto countPage(int page,int pageSize,String name){
        // 计算分页查询时的起始索引
        int pages = (page-1) * pageSize;
        return new PageDto(pages,pageSize,name);
    }
}
