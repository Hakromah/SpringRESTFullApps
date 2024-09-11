package com.telusko.services;

import com.telusko.StudentDockerAppException;
import com.telusko.entity.Student;
import com.telusko.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public String saveStudent(Student student) {
        repo.save(student);
        return "Student added successfully with id: " + student.getId();
    }

    @Override
    public Student getStudent(Integer id) {
        Optional<Student> optional = repo.findById(id);
        return optional.orElseGet(() -> repo.findById(id).get());
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public String deleteStudent(Integer id) {
        Optional<Student> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Student with id: " + id + " deleted successfully";
        } else {
            throw new StudentDockerAppException("Student with id: " + id + "not found");
        }
    }

    @Override
    public String updateStudent(Student student) {
        Optional<Student> optional = repo.findById(student.getId());
        if (optional.isPresent()) {
            repo.save(student);
            return "Student with id: " + student.getId() + " updated successfully";
        } else {
            throw new StudentDockerAppException("Student with id: " + student.getId() + "not found");
        }
    }

    @Override
    public Student updateStudentById(Student student, Integer id) {
        Optional<Student> optional = repo.findById(id);
        if (optional.isPresent()) {
            student.setId(id);
            repo.save(student);
            return student;
        } else {
            throw new StudentDockerAppException("Student with id: " + id + "not found to update");
        }
    }
}
