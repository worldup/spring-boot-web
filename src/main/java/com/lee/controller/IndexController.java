package com.lee.controller;

import com.lee.dao.rest.RestDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lili on 15-8-23.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Value("${application.name:Hello World}")
   private String name;

    @RequestMapping("/index")
    @RequiresRoles("ADMIN")
    public String index(Model model){
        model.addAttribute("name",name);
//        SecurityUtils.getSubject().checkRole("Admin");
        return "index";
    }
    @RequestMapping("/login")
    public String login(   ){
        UsernamePasswordToken token=new UsernamePasswordToken();
        token.setUsername("li");
        token.setPassword("li".toCharArray());
        SecurityUtils.getSubject().login(token);
        return "login";
    }
}
