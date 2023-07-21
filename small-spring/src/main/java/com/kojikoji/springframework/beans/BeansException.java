package com.kojikoji.springframework.beans;

/**
 * @ClassName BeanException
 * @Description 自定义Bean异常
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 16:10
 * @Version
 */

public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
