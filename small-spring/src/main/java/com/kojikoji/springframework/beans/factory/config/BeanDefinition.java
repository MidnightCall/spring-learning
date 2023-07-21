package com.kojikoji.springframework.beans.factory.config;

import com.kojikoji.springframework.PropertyValues;
import lombok.Data;

/**
 * @ClassName BeanDefinition
 * @Description 基础Bean定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:11
 * @Version
 */
@Data
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        // 防止for循环判空异常
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
}
