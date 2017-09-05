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

public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testPage(){
        Pageable pageable=new PageRequest(1,9);
        Page<Employee> employeePage=employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("总页数为："+employeePage.getTotalPages());
        System.out.println("总记录数为："+employeePage.getTotalElements());
        System.out.println("当前页数为："+(employeePage.getNumber()+1));
        System.out.println("当前页数集合："+employeePage.getContent());
        System.out.println("当前页面的记录数："+employeePage.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=new Sort(order);
        Pageable pageable=new PageRequest(3,10,sort);
        Page<Employee> employeePage=employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("总页数为："+employeePage.getTotalPages());
        System.out.println("总记录数为："+employeePage.getTotalElements());
        System.out.println("当前页数为："+(employeePage.getNumber()+1));
        System.out.println("当前页数集合："+employeePage.getContent());
        System.out.println("当前页面的记录数："+employeePage.getNumberOfElements());
    }

}
