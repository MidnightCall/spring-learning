package com.kojikoji.springframework.beans.factory;

/**
 * @ClassName BeanClassLoaderAware
 * @Description 感知到所属的 ClassLoader
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/5 15:08
 * @Version
 */

public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}
