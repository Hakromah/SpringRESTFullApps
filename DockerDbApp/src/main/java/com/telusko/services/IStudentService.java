package com.telusko.services;

import com.telusko.entity.Student;

import java.util.List;

public interface IStudentService {

    String saveStudent(Student student);

    Student getStudent(Integer id);

    List<Student> getAllStudents();

    String deleteStudent(Integer id);

    String updateStudent(Student student);
    Student updateStudentById(Student student, Integer id);
}
