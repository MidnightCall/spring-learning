package com.kojikoji.springframework.beans.factory.config;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @ClassName BeanFactoryPostProcessor
 * @Description 在注册之后实例化之前，提供修改BeanDefinition的机制
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 21:21
 * @Version
 */

public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition加载完之后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
