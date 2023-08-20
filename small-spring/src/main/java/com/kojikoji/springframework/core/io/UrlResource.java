package com.kojikoji.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName UrlResource
 * @Description 通过http的方式读取云服务的文件，可将配置文件通过github或者gitee托管
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 17:00
 * @Version
 */

public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn = this.url.openConnection();
        try {
            return conn.getInputStream();
        } catch (IOException ex) {
            if(conn instanceof HttpURLConnection) {
                ((HttpURLConnection) conn).disconnect();
            }
            throw ex;
        }
    }
}
