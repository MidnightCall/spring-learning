package com.kojikoji.springframework.beans.factory;

/**
 * @ClassName DisposableBean
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/4 18:14
 * @Version
 */

public interface DisposableBean {

    void destroy() throws Exception;
}
