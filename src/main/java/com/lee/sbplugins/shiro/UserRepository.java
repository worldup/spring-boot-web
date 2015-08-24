package com.lee.sbplugins.shiro;

import org.springframework.stereotype.Repository;

/**
 * DAO for {@link User}.
 */
@Repository
public class UserRepository  {

    public User findByEmail(String email){
        User user=new User();
        user.setName("li");
        return user;
    }

    public  User findByEmailAndActive(String email, boolean active){
        User user=new User();
        user.setName("li");
        user.setPassword("li");
        return user;
    }

}