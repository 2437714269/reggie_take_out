package com.acer.utils;


/**
 * 检查是否不为空（!null 与 !""）
 * @author acer
 */
public class CheckParamUtils {

    /**
     * 验证为空为空
     * @author acer
     * @date 9:41 2022/8/2
     * @param param 需要验证的账号对象
     * @return boolean
    **/
    public static boolean isNullOrEmpty(Object param){
        return param == null || "".equals(param.toString());
    }

    /**
     * 账号验证不为空
     * @author acer
     * @date 9:58 2022/8/2
     * @param param 需要验证的账号对象
     * @return boolean
    **/
    public static boolean isNotNullAndNotEmpty(Object param){
        return param !=null && !"".equals(param.toString());
    }
}
