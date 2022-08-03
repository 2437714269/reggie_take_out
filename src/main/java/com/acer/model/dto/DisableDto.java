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
public class DisableDto {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户状态
     */
    private Integer status;

}
