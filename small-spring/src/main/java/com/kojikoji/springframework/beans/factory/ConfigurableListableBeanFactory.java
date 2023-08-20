package com.kojikoji.springframework.beans.factory;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName ConfigurableListableBeanFactory
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 20:33
 * @Version
 */

public interface ConfigurableListableBeanFactory extends HierarchicalBeanFactory, ListableBeanFactory, AutowireCapableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
