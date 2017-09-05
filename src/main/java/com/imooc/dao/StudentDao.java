package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

/**
 * studentdao访问接口
 */
public interface StudentDao {

    /**
     * 查询所有学生
     * @return 所有学生
     */
    List<Student> query();

    /**
     * 添加一个学生
     * @param student 待添加的学生
     */
    void save(Student student);

}
