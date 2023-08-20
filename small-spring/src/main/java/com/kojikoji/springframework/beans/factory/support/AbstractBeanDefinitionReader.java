package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.core.io.DefaultResourceLoader;
import com.kojikoji.springframework.core.io.ResourceLoader;
import lombok.Getter;

/**
 * @ClassName AbstractBeanDefinitionReader
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 19:27
 * @Version
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
