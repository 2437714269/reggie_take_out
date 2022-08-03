package com.acer.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 菜品及套餐分类
 * @TableName category
 * @author acer
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category implements Serializable {

    /**
    * 主键
    */
    private Long id;
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
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
    /**
    * 创建人
    */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    /**
    * 修改人
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
