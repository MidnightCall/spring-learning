package com.kojikoji.springframework.beans.factory.context.support;

import com.kojikoji.springframework.beans.BeansException;

import java.util.Map;

/**
 * @ClassName ClassPathXmlApplicationContext
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/10/10 9:38
 * @Version
 */

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
