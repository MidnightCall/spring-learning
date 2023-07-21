package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DefaultSingletonBeanRegistry
 * @Description 已创建对象的获取
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:13
 * @Version
 */

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 获取已注册对象
     * @param beanName
     * @return
     */
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 创建单例对象
     * @param beanName
     * @param singletonObject
     */
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
