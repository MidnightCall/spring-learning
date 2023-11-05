package com.kojikoji.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.PropertyValues;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanReference;
import com.kojikoji.springframework.beans.factory.context.support.ClassPathXmlApplicationContext;
import com.kojikoji.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kojikoji.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.kojikoji.springframework.core.io.DefaultResourceLoader;
import com.kojikoji.springframework.core.io.Resource;
import com.kojikoji.springframework.test.bean.UserService;
import com.kojikoji.springframework.test.common.MyBeanFactoryPostProcessor;
import com.kojikoji.springframework.test.common.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.spi.IIOServiceProvider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ApiTest
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/17 9:49
 * @Version
 */

public class ApiTest {

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2.获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3.配置 scope
        System.out.println(userService01);
        System.out.println(userService02);
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2.调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
