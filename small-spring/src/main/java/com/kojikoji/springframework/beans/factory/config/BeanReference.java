package com.kojikoji.springframework.beans.factory.config;

/**
 * @ClassName BeanReference
 * @Description bean的引用
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 19:17
 * @Version
 */

public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
