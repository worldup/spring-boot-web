package com.lee.sbplugins.shiro;


import java.util.ArrayList;
import java.util.List;



public class User {


    private String id;

    private Long created;
    private String email;
    private String name;
    private Boolean active;
    private String password;

    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        if (roles == null) {
            this.roles = new ArrayList<Role>();
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}