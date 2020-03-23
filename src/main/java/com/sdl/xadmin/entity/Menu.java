package com.sdl.xadmin.entity;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author sdl
 * @since 2020-03-22 15:15:14
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -46495826893019248L;
    
    private Integer id;
    
    private String icon;
    
    private String name;
    
    private String url;
    
    private Integer pid;
    
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", description='" + description + '\'' +
                '}';
    }
}