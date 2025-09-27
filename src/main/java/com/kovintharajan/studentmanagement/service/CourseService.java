package com.kovintharajan.studentmanagement.service;

import com.kovintharajan.studentmanagement.model.Course;
import com.kovintharajan.studentmanagement.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) throws ExecutionException, InterruptedException {
        return courseRepository.createCourse(course);
    }

    public Course getCourseById(String id) throws ExecutionException, InterruptedException {
        return courseRepository.getCourseById(id);
    }

    public List<Course> getAllCourses() throws ExecutionException, InterruptedException {
        return courseRepository.getAllCourses();
    }

    public Course updateCourse(Course course) throws ExecutionException, InterruptedException {
        Course existingCourse = courseRepository.getCourseById(course.getId());
        if (existingCourse == null) {
            throw new IllegalArgumentException("Course not found with ID: " + course.getId());
        }
        return courseRepository.updateCourse(course);
    }

    public String deleteCourseById(String id) throws ExecutionException, InterruptedException {
        Course existingCourse = courseRepository.getCourseById(id);
        if (existingCourse == null) {
            throw new IllegalArgumentException("Course not found with ID: " + id);
        }
        return courseRepository.deleteCourseById(id);
    }
}