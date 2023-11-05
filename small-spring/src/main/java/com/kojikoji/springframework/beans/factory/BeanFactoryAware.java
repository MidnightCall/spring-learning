package com.kojikoji.springframework.beans.factory;

import com.kojikoji.springframework.beans.BeansException;

/**
 * @ClassName BeanFactoryAware
 * @Description 实现此接口可以感知到所属的 BeanFactory
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/5 15:06
 * @Version
 */

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
