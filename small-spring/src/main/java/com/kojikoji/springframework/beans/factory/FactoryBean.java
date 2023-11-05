package com.kojikoji.springframework.beans.factory;

/**
 * @ClassName FactoryBean
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/5 16:52
 * @Version
 */

public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
