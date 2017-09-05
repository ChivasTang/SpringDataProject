package com.imooc.util;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {

    private ApplicationContext ctx=null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource= (DataSource)ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        System.out.println(dataSource.toString());
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
        System.out.println(jdbcTemplate.getQueryTimeout());
    }
}
