package com.zzp.creation.prototype;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 浅克隆User
 * @Author Garyzeng
 * @since 2019.11.23
 **/
public class User implements Serializable, Cloneable{

    private static final long serialVersionUID = -1L;

    private Integer id;

    private String username;

    private String password;

    private List<String> roles;

    public User(Integer id, String username, String password, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
