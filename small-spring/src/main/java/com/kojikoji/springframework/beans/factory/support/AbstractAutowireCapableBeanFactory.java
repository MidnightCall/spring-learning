package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName AbstractAutowireCapableBeanFactory
 * @Description bean工厂自动装配
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:12
 * @Version
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        // 尝试实例化bean，实例化时创建对象
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 将创建对象加入单例
        addSingleton(beanName, bean);
        return bean;
    }
}
