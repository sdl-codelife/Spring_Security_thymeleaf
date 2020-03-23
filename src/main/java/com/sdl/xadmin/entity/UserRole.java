package com.sdl.xadmin.entity;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author sdl
 * @since 2020-03-22 15:15:14
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 347528469394069149L;
    
    private Integer id;
    
    private Integer userid;
    
    private Integer roleid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}