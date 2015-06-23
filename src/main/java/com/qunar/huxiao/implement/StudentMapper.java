package com.qunar.huxiao.implement;

import com.qunar.huxiao.Student.Student;

import java.util.List;

/**
 * Created by xiao.hu on 2015/6/23.
 */
public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(String id);
    void insertStudent(Student student);
    void deleteStudent(String id);
    void modifyStudent(Student student);
}
