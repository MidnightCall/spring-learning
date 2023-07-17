package com.kojikoji.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName BeanFactory
 * @Description bean工厂
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/17 9:48
 * @Version
 */

public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * bean装配
     * @param name  bean名称
     * @return      装配对象
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册bean
     * @param name 名称
     * @param beanDefinition bean定义
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
