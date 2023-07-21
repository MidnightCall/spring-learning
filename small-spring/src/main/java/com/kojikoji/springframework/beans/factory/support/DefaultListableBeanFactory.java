package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DefaultListableBeanFactory
 * @Description 核心类，Bean注册和获取注册对象的实现
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:13
 * @Version
 */

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取已注册的Bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    /**
     * 注册Bean定义
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
