package com.kojikoji.springframework.beans.factory;

import com.kojikoji.springframework.beans.BeansException;

import java.util.Map;

/**
 * @ClassName ListableBeanFactory
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 20:34
 * @Version
 */

public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按类型返回 Bean 实例
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中的所有Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
