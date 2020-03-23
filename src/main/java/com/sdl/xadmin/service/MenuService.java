package com.sdl.xadmin.service;

import com.sdl.xadmin.dao.MenuDao;
import com.sdl.xadmin.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    MenuDao menuDao;
    public List<Menu> findMenuByUserId(Integer userId){
        return menuDao.queryByUserId(userId);
    }
}
