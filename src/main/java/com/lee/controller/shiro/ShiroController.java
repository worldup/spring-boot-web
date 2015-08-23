package com.lee.controller.shiro;

import com.lee.sbplugins.shiro.User;
import com.lee.sbplugins.shiro.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * TODO add description
 */
@RestController
@RequestMapping("/users")
public class ShiroController {

    private static final Logger log = LoggerFactory.
            getLogger(ShiroController.class);



    @Autowired
    private UserRepository userRepo;



    @RequestMapping(value = "/auth", method = POST)
    public void authenticate(@RequestBody final UsernamePasswordToken credentials) {
        log.info("Authenticating {}", credentials.getUsername());
        final Subject subject = SecurityUtils.getSubject();
        subject.login(credentials);
        // set attribute that will allow session querying
        subject.getSession().setAttribute("email", credentials.getUsername());
    }

    @RequestMapping(method = GET)
    @RequiresAuthentication
    @RequiresRoles("ADMIN")
    public List<User> getAll() {
       return   Arrays.asList(userRepo.findByEmail("")) ;
    }

    @RequestMapping(value = "do_something", method = GET)
    @RequiresAuthentication
    @RequiresRoles("DO_SOMETHING")
    public List<User> dontHavePermission() {
        return   Arrays.asList(userRepo.findByEmail("")) ;
    }


}