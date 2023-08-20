package com.kojikoji.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.kojikoji.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ClassPathResource
 * @Description 通过ClassLoader读取ClassPath下的文件
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 16:59
 * @Version
 */

public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
