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

public class UserService {

    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

}
