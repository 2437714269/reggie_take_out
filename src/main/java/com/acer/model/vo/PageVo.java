package com.acer.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author 返回给前端分页查询的数据
 */
@Data
@AllArgsConstructor
public class PageVo<T> {

    /**
     * 返回给前端的数据
     */
    private List<T> records;

    /**
     * 总的记录数
     */
    private long total;

    /**
     * 查询到的总数条数
     */
    private long size;
}
