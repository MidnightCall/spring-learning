package com.kojikoji.springframework.beans.factory.config;

/**
 * @ClassName SingletonBeanRegistry
 * @Description 获取单例对象的接口，或者说，获取已创建的bean
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:12
 * @Version
 */

public interface SingletonBeanRegistry {
    /**
     * 获取单例对象接口
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
