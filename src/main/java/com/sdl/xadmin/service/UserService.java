package com.sdl.xadmin.service;

import com.sdl.xadmin.dao.UserDao;
import com.sdl.xadmin.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserDao userDao;

    public User findUserByName(String userName){
        return userDao.queryByName(userName);
    }
}
