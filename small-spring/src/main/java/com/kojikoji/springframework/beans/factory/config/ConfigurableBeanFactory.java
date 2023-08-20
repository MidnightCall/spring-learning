package com.kojikoji.springframework.beans.factory.config;

import com.kojikoji.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @ClassName ConfigurableBeanFactory
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 20:38
 * @Version
 */

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
}
