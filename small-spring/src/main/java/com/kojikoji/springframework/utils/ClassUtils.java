package com.kojikoji.springframework.utils;

import cn.hutool.core.util.ClassUtil;

/**
 * @ClassName ClassUtils
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 17:03
 * @Version
 */

public class ClassUtils {

    /**
     * 获取默认类加载器，获取顺序:线程类加载器->本类类加载器
     * @return
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // 不能访问线程上下文类加载器
        }
        if(classLoader == null) {
            // 无线程上下文类加载器时，使用本类的类加载器
            classLoader = ClassUtils.class.getClassLoader();
        }

        return classLoader;
    }
}
