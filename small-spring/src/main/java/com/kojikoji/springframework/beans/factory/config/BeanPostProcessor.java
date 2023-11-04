package com.kojikoji.springframework.beans.factory.config;

import com.kojikoji.springframework.beans.BeansException;

import java.beans.Beans;

/**
 * @ClassName BeanPostProcessor
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/10/9 20:23
 * @Version
 */

public interface BeanPostProcessor {
    /**
     * Bean 对象执行初始化之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
