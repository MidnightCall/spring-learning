package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName BeanDefinitionRegistry
 * @Description bean注册接口
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:13
 * @Version
 */

public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
