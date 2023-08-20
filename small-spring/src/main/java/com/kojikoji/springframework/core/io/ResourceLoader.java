package com.kojikoji.springframework.core.io;

/**
 * @ClassName ResourceLoader
 * @Description 获取资源接口定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 17:23
 * @Version
 */

public interface ResourceLoader {
    // url前缀
    String CLASS_PATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
