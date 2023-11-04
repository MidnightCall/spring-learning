package com.kojikoji.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.DisposableBean;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @ClassName DisposableBeanAdaptor
 * @Description 适配器类，对于 DisposableBean 与注解实现 destroy-method 统一处理
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/4 19:47
 * @Version
 */

public class DisposableBeanAdaptor implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdaptor(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1.实现接口DisposableBean
        if(bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2.注解配置 destroy-method (避免二次销毁)
        if(StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (destroyMethod == null) {
                throw new BeansException("Couldn't find destroy method named '" + destroyMethodName + "'on bean with name" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
