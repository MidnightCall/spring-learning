package com.kojikoji.springframework.test;

import com.kojikoji.springframework.BeanDefinition;
import com.kojikoji.springframework.BeanFactory;
import com.kojikoji.springframework.test.bean.UserService;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;

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
        BeanFactory beanFactory = new BeanFactory();

        // 2.创建bean
        BeanDefinition userServiceBean = new BeanDefinition(new UserService());

        // 3.注册bean到工厂
        beanFactory.registerBeanDefinition("userService", userServiceBean);

        // 4.装配bean
        UserService userService = (UserService) beanFactory.getBean("userService");

        // 5.调用
        userService.query();
    }
}
