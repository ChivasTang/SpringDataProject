package com.imooc.service;

import com.imooc.domain.Employee;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 5, 2017</pre>
 */
public class EmployeeServiceTest {
    private ApplicationContext ctx;
    private EmployeeService employeeService;

    @Before
    public void before() throws Exception {
        ctx =new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService=ctx.getBean(EmployeeService.class);
        System.out.println("Before");
    }

    @After
    public void after() throws Exception {
        ctx=null;
        System.out.println("After");
    }

    /**
     * Method: save(List<Employee> employeeList)
     */
    @Test
    public void testSave() throws Exception {
        List<Employee> employeeList=new ArrayList<Employee>();
        Employee employee;
        for(int i=0;i<100;i++){
            employee= new Employee();
            employee.setName("test10"+i);
            employee.setAge((int)(Math.random()*30)+20);
            System.out.println(employee.toString());
            employeeList.add(employee);
        }
        employeeService.save(employeeList);
    }


} 
