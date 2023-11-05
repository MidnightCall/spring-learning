package com.kojikoji.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserDao
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 19:18
 * @Version
 */

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("100001", "kojikoji");
        hashMap.put("100002", "harutya");
        hashMap.put("100003", "osamu");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
