package com.lee.dao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lili on 15-8-23.
 */
@Repository
public class RestDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void test(){
        System.out.println(jdbcTemplate.getDataSource());
    }
}
