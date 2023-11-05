package com.kojikoji.springframework.beans.factory.context.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.config.BeanPostProcessor;
import com.kojikoji.springframework.beans.factory.context.ApplicationContext;
import com.kojikoji.springframework.beans.factory.context.ApplicationContextAware;

/**
 * @ClassName ApplicationContextAwareProcessor
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/5 15:16
 * @Version
 */

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
