package com.kojikoji.springframework.test.bean;

/**
 * @ClassName UserService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/17 9:49
 * @Version
 */

public class UserService {

    private String uId;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uId) {
        this.uId = uId;
    }

    public void query() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(uId);
        return sb.toString();
    }
}
