package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.BeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @ClassName InstantiationStrategy
 * @Description 实例化策略接口
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 17:08
 * @Version
 */

public interface InstantiationStrategy {

    /**
     * 含参初始化
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
