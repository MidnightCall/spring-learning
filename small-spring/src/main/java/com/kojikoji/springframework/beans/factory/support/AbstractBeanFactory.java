package com.kojikoji.springframework.beans.factory.support;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.BeanFactory;
import com.kojikoji.springframework.beans.factory.FactoryBean;
import com.kojikoji.springframework.beans.factory.ListableBeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanPostProcessor;
import com.kojikoji.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.kojikoji.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AbstractBeanFactory
 * @Description BeanFactory接口的实现
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:11
 * @Version
 */

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    // ClassLoader to resolve bean class names with, if necessary
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    // 统一封装为模板方法
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 尝试获取单例对象
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 若为 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }

        // 获取失败，进行相应的实例化
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);

        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if(!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);

        if(object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

    // 获取bean定义，由DefaultListableBeanFactory实现
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 实例化bean，由AbstractAutowireCapableBeanFactory实现
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
