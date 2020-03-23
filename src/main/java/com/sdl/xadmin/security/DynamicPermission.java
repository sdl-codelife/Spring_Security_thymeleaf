package com.sdl.xadmin.security;

import com.sdl.xadmin.entity.Menu;
import com.sdl.xadmin.entity.User;
import com.sdl.xadmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class DynamicPermission {
    @Autowired
    private MenuService menuService;
    public boolean checkPermission(HttpServletRequest request, Authentication auth) {
        Object principal = auth.getPrincipal();
        if(principal instanceof UserDetails){
            User user = (User) principal;
            List<Menu> menus = menuService.findMenuByUserId(user.getId());
            System.out.println(menus);
            //url匹配 /**
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前访问路径
            String requestURI = request.getRequestURI();
            System.out.println(user.getUsername()+"当前访问"+requestURI);
            boolean rs = menus.stream().anyMatch(item -> {
                boolean hashPath = antPathMatcher.match(item.getUrl(),requestURI);
                return hashPath;
            });
            if (rs) {
                return rs;
            }else {
                throw  new AccessDeniedException("不是UserDetails类型！");
            }

        }else {
            throw  new AccessDeniedException("不是UserDetails类型！");
        }
    }
}
