package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx;
    private EmployeeJpaRepository employeeJpaRepository;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        Employee employee=employeeJpaRepository.findOne(99);
        System.out.println(employee.toString());
        System.out.println("employee(10):"+employeeJpaRepository.exists(10));
        System.out.println("employee(120):"+employeeJpaRepository.exists(120));
    }
}
