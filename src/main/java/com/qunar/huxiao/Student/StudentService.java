package com.qunar.huxiao.Student;

import java.util.List;

import com.qunar.huxiao.implement.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qunar.huxiao.MyBatisSqlSessionFactory;
/**
 * Created by xiao.hu on 2015/6/23.
 */
public class StudentService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Student> findAllStudents() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        } finally {
            // TODO: handle exception
            sqlSession.close();
        }
    }

    public Student findStudentById(String studId) {
        logger.debug("Select Student By ID:{}", studId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        } finally {
            // TODO: handle exception
            sqlSession.close();
        }
    }

    public void createStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        }finally {

            sqlSession.close();
        }
    }

    public void  deleteStudent(String studId){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudent(studId);
            sqlSession.commit();
        }finally {

            sqlSession.close();
        }
    }

    public void modifyStudent(Student student){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.modifyStudent(student);
            sqlSession.commit();
        }finally {

            sqlSession.close();
        }
    }
}
