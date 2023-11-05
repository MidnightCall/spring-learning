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
import com.kojikoji.springframework.test.bean.UserDao;
import com.kojikoji.springframework.test.bean.UserService;
import com.kojikoji.springframework.test.common.MyBeanFactoryPostProcessor;
import com.kojikoji.springframework.test.common.MyBeanPostProcessor;
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
        userService.queryUserInfo();
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
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

        System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }

    /**
     * 不使用注册上下文
     */
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3.BeanDefinition加载完成 & Bean实例化之前，修改BeanDefinition属性
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4.Bean实例化之后，修改Bean的属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5.获取Bean对象的调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果:" + result);
    }

    @Test
    public void test_applicationContext() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2.获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果:" + userService.queryUserInfo());
        StringBuilder sb = new StringBuilder();
        
    }


}
