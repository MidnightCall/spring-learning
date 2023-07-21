package com.kojikoji.springframework.beans.factory.config;

/**
 * @ClassName BeanDefinition
 * @Description 基础Bean定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:11
 * @Version
 */

public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
