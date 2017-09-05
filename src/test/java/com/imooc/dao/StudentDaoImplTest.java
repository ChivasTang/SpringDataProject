package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoImplTest {

    @Test
    public void testQuery(){
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> students=studentDao.query();
        for(Student student : students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void testSave(){
        StudentDao studentDao=new StudentDaoImpl();
        Student student=new Student();
        student.setName("tangzhihua");
        student.setAge(33);
        studentDao.save(student);
    }
}
