package com.kojikoji.springframework.beans.factory.context;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.Aware;

/**
 * @ClassName ApplicationContextAware
 * @Description 感知所属的 ApplicationContext
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/11/5 15:12
 * @Version
 */

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
