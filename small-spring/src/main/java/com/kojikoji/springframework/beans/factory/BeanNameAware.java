package com.kojikoji.springframework.beans.factory;

/**
 * @ClassName BeanNameAware
 * @Description 感知所属的BeanName
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/5 15:10
 * @Version
 */

public interface BeanNameAware extends Aware {
    void setBeanName(String beanName);
}
