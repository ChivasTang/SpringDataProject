package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx=null;
    private EmployeeRepository employeeRepository=null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
        Employee employee=employeeRepository.findByName("zhangsan");
        System.out.println(employee.toString());
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan(){
        List<Employee> employeeList=employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);
        for(Employee employee:employeeList){
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testFindByNameInOrAgeLessThan(){
        List<String> names=new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees=employeeRepository.findByNameInOrAgeLessThan(names,22);
        for(Employee employee:employees){
            System.out.println(employee.toString());
        }
    }
}
