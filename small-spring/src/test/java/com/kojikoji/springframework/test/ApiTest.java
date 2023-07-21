package com.kojikoji.springframework.test;

import com.kojikoji.springframework.beans.factory.BeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kojikoji.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
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
        // 1.创建工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.创建注册对象
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取
        UserService userService = (UserService) beanFactory.getBean("userService", "kojikoji");

        // 4.调用方法
        userService.query();
    }
}
