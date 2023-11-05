package com.kojikoji.springframework.test.bean;

import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.factory.BeanClassLoaderAware;
import com.kojikoji.springframework.beans.factory.BeanFactory;
import com.kojikoji.springframework.beans.factory.BeanFactoryAware;
import com.kojikoji.springframework.beans.factory.BeanNameAware;
import com.kojikoji.springframework.beans.factory.context.ApplicationContext;
import com.kojikoji.springframework.beans.factory.context.ApplicationContextAware;

/**
 * @ClassName UserService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/17 9:49
 * @Version
 */

public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    private String uId;

    private String company;

    private String location;

    private UserDao userDao;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("Bean Name is:" + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public UserService() {
    }

    public UserService(String uId) {
        this.uId = uId;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ",公司:" + company + ", 地点" + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

}
