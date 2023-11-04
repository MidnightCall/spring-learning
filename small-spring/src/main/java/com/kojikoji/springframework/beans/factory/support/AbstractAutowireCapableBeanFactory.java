package com.kojikoji.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.PropertyValues;
import com.kojikoji.springframework.beans.factory.DisposableBean;
import com.kojikoji.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanPostProcessor;
import com.kojikoji.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @ClassName AbstractAutowireCapableBeanFactory
 * @Description bean工厂自动装配
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:12
 * @Version
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        // 尝试实例化bean，实例化时创建对象
        Object bean = null;
        try {
            // 创建实例
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行Bean的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        // 将创建对象加入单例
        addSingleton(beanName, bean);
        return bean;
    }

    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if(bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdaptor(bean, beanName, beanDefinition));
        }
    }

    /**
     * 属性的注入
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValue[] propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
            for (PropertyValue propertyValue : propertyValues) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if(value instanceof BeanReference) {
                    // 属性属于应用类型
                    BeanReference beanReference = (BeanReference) value;
                    // 递归创建
                    value = getBean(beanReference.getBeanName());
                }

                // 填充属性
                BeanUtil.setProperty(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        // 构造器初始化为null
        Constructor constructorToUse = null;
        // 获取bean类型
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取构造器数组
        Constructor<?>[] declaredConstructor = beanClass.getDeclaredConstructors();

        for(Constructor ctor : declaredConstructor) {
            // 循环比对构造器的参数数量和给定的参数数量
            if(null != args && ctor.getParameterCount() == args.length) {
                // 不为空且参数数量一致，返回
                constructorToUse = ctor;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1.执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        
        // 2.执行Bean对象的初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        // 3.执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }
}
