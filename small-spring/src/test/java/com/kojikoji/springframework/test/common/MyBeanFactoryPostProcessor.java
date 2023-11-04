package com.kojikoji.springframework.test.common;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.PropertyValues;
import com.kojikoji.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @ClassName MyBeanFactoryPostProcessor
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/10/11 14:24
 * @Version
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addProperty(new PropertyValue("company", "改为：小米"));
    }
}
