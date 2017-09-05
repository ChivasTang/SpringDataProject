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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    /**
     * 分页
     * 排序
     * 查询条件:年龄>50
     */
    @Test
    public void testQuery(){

        Sort.Order order=new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort=new Sort(order);

        Pageable pageable=new PageRequest(5,5,sort);
        Specification<Employee> specification=new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Path path=root.get("age");
                return criteriaBuilder.gt(path,40);
            }
        };
        Page<Employee> employeePage=employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);

        System.out.println("总页数为："+employeePage.getTotalPages());
        System.out.println("总记录数为："+employeePage.getTotalElements());
        System.out.println("当前页数为："+(employeePage.getNumber()+1));
        System.out.println("当前页数集合："+employeePage.getContent());
        System.out.println("当前页面的记录数："+employeePage.getNumberOfElements());
    }
}
