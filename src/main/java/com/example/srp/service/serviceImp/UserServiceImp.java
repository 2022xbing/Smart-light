package com.example.srp.service.serviceImp;

import com.example.srp.domian.User;
import com.example.srp.mapper.UserDao;
import com.example.srp.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) user.setPassword("");
        return user;
    }

    @Override
    public User registerService(User user) {
        if (userDao.findByUsername(user.getUsername()) != null) {
            //存在该用户
            return null;
        } else {
            userDao.addUser(user);
            System.out.println(user);
            if (user != null) user.setPassword("");
            return user;
        }
    }
}
