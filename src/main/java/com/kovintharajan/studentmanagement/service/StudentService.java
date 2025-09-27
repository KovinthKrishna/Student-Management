package com.kovintharajan.studentmanagement.service;

import com.kovintharajan.studentmanagement.model.Student;
import com.kovintharajan.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Student> getAllStudents() throws ExecutionException, InterruptedException {
        return studentRepository.getAllStudents();
    }

    public Student updateStudent(Student student) throws ExecutionException, InterruptedException {
        Student existingStudent = studentRepository.getStudentById(student.getId());
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student not found with ID: " + student.getId());
        }
        return studentRepository.updateStudent(student);
    }

    public String deleteStudentById(String id) throws ExecutionException, InterruptedException {
        Student existingStudent = studentRepository.getStudentById(id);
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student not found with ID: " + id);
        }
        return studentRepository.deleteStudentById(id);
    }
}