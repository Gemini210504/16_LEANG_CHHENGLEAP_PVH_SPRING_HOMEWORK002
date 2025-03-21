package org.homework.spring_homework02.service.implement;


import org.homework.spring_homework02.model.entity.Student;
import org.homework.spring_homework02.model.request.StudentRequest;
import org.homework.spring_homework02.repository.StudentRepository;
import org.homework.spring_homework02.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.selectStudentById(id);
    }

    @Override
    public Student updateStudentById(Integer id, StudentRequest studentRequest) {
        return studentRepository.updateStudentById(studentRequest,id);
    }

    @Override
    public Student deleteById(Integer id) {
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> getAllStudents(Integer size, Integer page) {
        return studentRepository.retrieveAllStudents(size, page);
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        return studentRepository.createStudent(studentRequest);
    }

}
