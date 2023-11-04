package com.kojikoji.springframework.beans.factory.context.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.kojikoji.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName AbstractRefreshableApplicationContext
 * @Description 实现 BeanFactory 创建和 BeanDefinition 加载的 refresh() 方法
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/10/10 0:05
 * @Version
 */

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    protected DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 创建 beanFactory
     * @return
     */
    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载BeanDefinition
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /**
     * 获取 BeanFactory
     * @return
     */
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
