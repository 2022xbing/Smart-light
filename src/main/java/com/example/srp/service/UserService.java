package com.example.srp.service;

import com.example.srp.domian.User;

public interface UserService {
    /***
     * 登录业务逻辑
     * @param username
     * @param password
     * @return
     */
    User loginService(String username, String password);

    /***
     * 注册业务逻辑
     * @param user
     * @return
     */
    User registerService(User user);
}
