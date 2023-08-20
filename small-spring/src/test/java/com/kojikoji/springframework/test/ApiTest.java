package com.kojikoji.springframework.test;

import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.PropertyValues;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanReference;
import com.kojikoji.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kojikoji.springframework.test.bean.UserDao;
import com.kojikoji.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @ClassName ApiTest
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/17 9:49
 * @Version
 */

public class ApiTest {
    @Test
    public void test() {
        // 创建工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 注册UserDao
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 定义UserService属性集合
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addProperty(new PropertyValue("uId", "100001"));
        propertyValues.addProperty(new PropertyValue("userDao", new BeanReference("userDao")));

        // 注册UserService
        defaultListableBeanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));

        // 装配UserService
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");

        // 调用方法
        userService.query();
    }
}
