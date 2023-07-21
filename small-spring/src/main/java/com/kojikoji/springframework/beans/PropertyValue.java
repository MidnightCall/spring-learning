package com.kojikoji.springframework.beans;

import lombok.Data;

/**
 * @ClassName PropertyValue
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 19:17
 * @Version
 */
@Data
public class PropertyValue {
    // 字段名
    private String name;
    // 字段值
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
