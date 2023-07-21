package com.kojikoji.springframework.beans.factory;

import com.kojikoji.springframework.beans.BeansException;

/**
 * @ClassName BeanFactory
 * @Description bean工厂接口
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:12
 * @Version
 */

public interface BeanFactory {
    /**
     * 组装Bean
     * @param name  Bean名称
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 有参构造的组装Bean，传递入参来实例化
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;
}
