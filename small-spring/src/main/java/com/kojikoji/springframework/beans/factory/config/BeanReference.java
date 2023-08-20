package com.kojikoji.springframework.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName BeanReference
 * @Description 指明该Property是一个应用类
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 16:00
 * @Version
 */

@Data
@AllArgsConstructor
public class BeanReference {
    private final String beanName;
}
