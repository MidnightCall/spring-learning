package com.kojikoji.springframework.test.common;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.config.BeanPostProcessor;
import com.kojikoji.springframework.test.bean.UserService;

/**
 * @ClassName MyBeanPostProcessor
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/10/11 14:26
 * @Version
 */

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为:北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
