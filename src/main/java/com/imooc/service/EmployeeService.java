package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService{
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void save(List<Employee> employeeList){
        employeeCrudRepository.save(employeeList);
    }
}
