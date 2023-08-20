package com.kojikoji.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Resource
 * @Description 处理资源加载流
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 16:57
 * @Version
 */

public interface Resource {
    InputStream getInputStream() throws IOException;
}
