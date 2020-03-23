package com.sdl.xadmin;


import com.sdl.xadmin.entity.Menu;
import com.sdl.xadmin.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = XadminApplication.class)
class XadminApplicationTests {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleService roleService;
    @Test
    void contextLoads() {
       String a =  bCryptPasswordEncoder.encode("admin");
        System.out.println(a);
        //密码是否匹配
        boolean pass =   bCryptPasswordEncoder.matches("user","$2a$10$YZ6m5BHfaM2XCBDic6CkmuzD3smb8cpy/twBtBd0HRn3FYa44/LDi");
        //密码能够变得更安全吗？
       boolean passa =  bCryptPasswordEncoder.upgradeEncoding("$2a$10$YZ6m5BHfaM2XCBDic6CkmuzD3smb8cpy/twBtBd0HRn3FYa44/LDi");
        System.out.println(pass);
        System.out.println(passa);
    }

    @Test
    void testpermission(){
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        //当前访问路径
        List<String> menus = Arrays.asList("/a","/b");
        String requestURI = "/a";
        boolean rs = menus.stream().anyMatch(item -> {
            System.out.println("遍历"+item);
            boolean hashPath = antPathMatcher.match(item,requestURI);
            System.out.println("匹配吗"+hashPath);
            return hashPath;
        });


        System.out.println("结果"+rs);
    }
}
