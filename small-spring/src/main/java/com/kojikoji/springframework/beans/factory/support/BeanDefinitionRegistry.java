package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
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

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 使用Bean名称查询BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 返回定义的所有BeanDefinition名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
