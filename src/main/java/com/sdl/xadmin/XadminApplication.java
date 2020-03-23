package com.sdl.xadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sdl.xadmin.dao")
public class XadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XadminApplication.class, args);
    }

}
