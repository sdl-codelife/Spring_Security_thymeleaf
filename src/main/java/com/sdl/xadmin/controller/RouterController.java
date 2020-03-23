package com.sdl.xadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping("/{path}")
    public String adminrouter(@PathVariable("path") String path){
        return path;
    }
}
