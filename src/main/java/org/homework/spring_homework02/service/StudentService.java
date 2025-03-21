package org.homework.spring_homework02.service;

import org.homework.spring_homework02.model.entity.Student;
import org.homework.spring_homework02.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    Student getStudentById(Integer id);
    Student updateStudentById(Integer id, StudentRequest studentRequest);
    Student deleteById(Integer id);
    List<Student> getAllStudents(Integer size, Integer page);
    Student addStudent(StudentRequest studentRequest);
}
