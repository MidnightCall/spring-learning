package com.kojikoji.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.PropertyValues;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanReference;
import com.kojikoji.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kojikoji.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.kojikoji.springframework.core.io.DefaultResourceLoader;
import com.kojikoji.springframework.core.io.Resource;
import com.kojikoji.springframework.test.bean.UserDao;
import com.kojikoji.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

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

    private DefaultResourceLoader resourceLoader;

    @Before
    public void setUp() throws Exception {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_File() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/spring.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/MidnightCall/reggie_take_out/blob/master/src/main/resources/application.yml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 读取配置文件&注册Bean
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinition("src/test/resources/spring.xml");

        // 获取对象
        UserService userService = (UserService) beanFactory.getBean("userService");

        // 调用方法
        userService.query();
    }

}
