package com.qunar.huxiao;

import com.qunar.huxiao.Student.Student;
import com.qunar.huxiao.Student.StudentService;
import java.util.*;
import org.junit.*;

/**
 * Created by xiao.hu on 2015/6/23.
 */
public class StudentServiceTest {
    private static StudentService studentService;

    @BeforeClass
    public static void setup(){
        studentService = new StudentService();
    }
    @AfterClass
    public static void teardown(){
        studentService = null;
    }
    @Test
    public void testFindAllStudents(){
        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for (Student student : students)
        {
            System.out.println(student);
        }
    }
    @Test
    public void testFindStudentById(){
        Student student = studentService.findStudentById("102");
        Assert.assertNotNull(student);

        System.out.println(student);

    }
    @Test
    public void testInsertStudent(){
        Student student = new Student();
        student.setStudId("110");
        student.setName("陈粒");
        student.setSex("女");
        student.setAge(26);
        student.setAddress("北京");
        student.setMajor("音乐");

        studentService.createStudent(student);

        List<Student> students = studentService.findAllStudents();

        Assert.assertNotNull(students);

        for (Student newStudent : students)
        {
            System.out.println(newStudent);
        }
    }
    @Test
    public void testDeleteStudent(){
        studentService.deleteStudent("104");

        List<Student> students = studentService.findAllStudents();

        Assert.assertNotNull(students);

        for (Student student : students)
        {
            System.out.println(student);
        }
    }
    @Test
    public void testModifyStudent(){
        Student student = studentService.findStudentById("101");
        student.setAddress("新沟");
        studentService.modifyStudent(student);

        List<Student> students = studentService.findAllStudents();

        Assert.assertNotNull(students);

        for (Student newStudent : students)
        {
            System.out.println(newStudent);
        }
    }

}
