package com.kojikoji.springframework.beans.factory.context;

import com.kojikoji.springframework.beans.BeansException;

/**
 * @ClassName ConfigurableApplicationContext
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/10/9 20:26
 * @Version
 */

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
