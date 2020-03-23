package com.sdl.xadmin.security.service;

import com.sdl.xadmin.entity.User;
import com.sdl.xadmin.service.RoleService;
import com.sdl.xadmin.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByName(userName);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        user.setRoles(roleService.findRoleByUserId(user.getId()));
        System.out.println(user.getAuthorities());
        return user;
    }
}
