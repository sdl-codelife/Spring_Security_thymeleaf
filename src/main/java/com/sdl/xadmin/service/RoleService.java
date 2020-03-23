package com.sdl.xadmin.service;

import com.sdl.xadmin.dao.RoleDao;
import com.sdl.xadmin.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    @Resource
    RoleDao roleDao;

    public List<Role> findRoleByUserId(Integer userId){
       return roleDao.queryByUserId(userId);
    }
}
