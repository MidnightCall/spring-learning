package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.core.io.Resource;
import com.kojikoji.springframework.core.io.ResourceLoader;

/**
 * @ClassName BeanDefinitionReader
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 19:26
 * @Version
 */

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resource) throws BeansException;

    void loadBeanDefinition(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
