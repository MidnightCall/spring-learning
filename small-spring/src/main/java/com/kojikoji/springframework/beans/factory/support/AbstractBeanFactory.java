package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.BeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName AbstractBeanFactory
 * @Description BeanFactory接口的实现
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:11
 * @Version
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        // 尝试获取单例对象
        Object bean = getSingleton(name);
        if (bean != null) {
            // 获取成功，直接返回
            return bean;
        }

        // 获取失败，进行相应的实例化
        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name, beanDefinition);
    }

    /**
     * 获取bean定义，由DefaultListableBeanFactory实现
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 实例化bean，由AbstractAutowireCapableBeanFactory实现
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
