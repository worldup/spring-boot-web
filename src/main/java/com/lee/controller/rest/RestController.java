package com.lee.controller.rest;

import com.lee.dao.rest.RestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lili on 15-8-23.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private RestDao restDao;
    @RequestMapping("/user/{id}")
    public Map getUser(@PathVariable("id")String id)
    {
        System.out.println(id);
        Map map=new HashMap();
        map.put("id",id);
        restDao.test();
        return map;
    }
}
