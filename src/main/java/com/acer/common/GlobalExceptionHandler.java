package com.acer.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 * @author acer
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理
     * @author acer
     * @date 16:55 2022/7/27
     * @param ex
     * @return com.acer.common.R<java.lang.String>
    **/
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){

        log.error(ex.getMessage());
        // 1.判断捕获的异常是否是：Duplicate entry
        boolean duplicate_entry = ex.getMessage().contains("Duplicate entry");
        if(duplicate_entry){
            //截取出错的内容
            String[] exceptions = ex.getMessage().split(" ");
            String exception = exceptions[2];
            return R.error(exception + "用户已重复");
        }
        return R.error("未知异常");
    }
}
