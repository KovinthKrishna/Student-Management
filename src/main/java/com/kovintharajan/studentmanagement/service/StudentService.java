package com.kovintharajan.studentmanagement.service;

import com.kovintharajan.studentmanagement.model.Student;
import com.kovintharajan.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) throws ExecutionException, InterruptedException {
        return studentRepository.createStudent(student);
    }

    public Student getStudentById(String id) throws ExecutionException, InterruptedException {
        return studentRepository.getStudentById(id);
    }
}