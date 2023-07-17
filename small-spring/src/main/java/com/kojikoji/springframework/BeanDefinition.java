package com.kojikoji.springframework;

/**
 * @ClassName BeanDefinition
 * @Description bean定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/17 9:48
 * @Version
 */

public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
