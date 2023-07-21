package com.kojikoji.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.kojikoji.springframework.PropertyValues;
import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanReference;
import com.sun.org.apache.bcel.internal.Const;
import javafx.animation.ScaleTransition;

import javax.management.MBeanServerConnection;
import java.lang.reflect.Constructor;

/**
 * @ClassName AbstractAutowireCapableBeanFactory
 * @Description bean工厂自动装配
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:12
 * @Version
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        // 尝试实例化bean，实例化时创建对象
        Object bean;
        try {
            // 创建实例
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 将创建对象加入单例
        addSingleton(beanName, bean);
        return bean;
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

    // 属性填充
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 获取属性集
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        // 对每一个属性进行判断，若已交由spring管理，则通过spring进行实例化
        try {
            for(PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference) {
                    // 若为BeanReference类型，则进行递归创建
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
