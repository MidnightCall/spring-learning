package com.kojikoji.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName PropertyValue
 * @Description bean注册的单个属性声明
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 16:01
 * @Version
 */
@Data
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private Object value;
}
