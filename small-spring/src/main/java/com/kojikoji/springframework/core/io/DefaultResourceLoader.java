package com.kojikoji.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName DefaultResourceLoader
 * @Description 由location判断资源类型，并创建出资源对象
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 17:26
 * @Version
 */

public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if(location.startsWith(CLASS_PATH_URL_PREFIX)) {
            // 是否为ClassLoader加载器
            return new ClassPathResource(location.substring(CLASS_PATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
