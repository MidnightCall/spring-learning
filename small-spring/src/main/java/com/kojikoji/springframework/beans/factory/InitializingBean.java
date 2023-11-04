package com.kojikoji.springframework.beans.factory;

/**
 * @ClassName InitializingBean
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/4 18:13
 * @Version
 */

public interface InitializingBean {
    /**
     * Bean 处理了属性填充以后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
