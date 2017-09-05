package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * StudentDaoSpringJdbcImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 5, 2017</pre>
 */
public class StudentDaoSpringJdbcImplTest {

    private ApplicationContext ctx=null;
    private StudentDao studentDao=null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao=(StudentDao)ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    /**
     * Method: query()
     */
    @Test
    public void testQuery() throws Exception {
        List<Student> students = studentDao.query();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    /**
     * Method: save(Student student)
     */
    @Test
    public void testSave() throws Exception {
        Student student=new Student();
        student.setName("汤志华");
        student.setAge(18);
        studentDao.save(student);
    }

    /**
     * Method: getJdbcTemplate()
     */
    @Test
    public void testGetJdbcTemplate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setJdbcTemplate(JdbcTemplate jdbcTemplate)
     */
    @Test
    public void testSetJdbcTemplate() throws Exception {
//TODO: Test goes here... 
    }


} 
