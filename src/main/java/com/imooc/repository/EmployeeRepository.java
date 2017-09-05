package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Integer> {
    Employee findByName(String name);
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);
}
