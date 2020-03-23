package com.sdl.xadmin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (MenuRole)实体类
 *
 * @author sdl
 * @since 2020-03-22 15:15:14
 */
public class MenuRole implements Serializable {
    private static final long serialVersionUID = -40029381375110614L;
    
    private Integer id;
    
    private Integer roleid;
    
    private Integer menuid;

    private List<Menu> children;

    private List<Role> roles;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

}