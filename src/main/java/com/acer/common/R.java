package com.acer.common;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author acer
 */
@Data
public class R<T> {

    /**
     * 编码：1成功，0和其它数字为失败
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 动态数据
     */
    private Map map = new HashMap();

    /**
     * @param object 给定要返回的值
     * @param <T> 泛型
     * @return 返回R
     */
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    /**
     * @param msg 给定错误说明
     * @param <T> 泛型
     * @return 返回R
     */
    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    /**
     * @param key 给定key
     * @param value 给定value
     * @return 返回R
     */
    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
