package org.homework.spring_homework02.controller;


import jakarta.websocket.server.PathParam;
import org.homework.spring_homework02.model.entity.Course;
import org.homework.spring_homework02.model.entity.Student;
import org.homework.spring_homework02.model.request.StudentRequest;
import org.homework.spring_homework02.model.response.ApiResponse;
import org.homework.spring_homework02.repository.StudentRepository;
import org.homework.spring_homework02.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents(Integer page, Integer size) {
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>> builder()
                .success(true)
                .message("Get data from database successfully")
                .status(HttpStatus.OK)
                .payload(studentService.getAllStudents(size,page))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody StudentRequest studentRequest) {
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Add data to database successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(studentService.addStudent(studentRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping ("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Integer id) {
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Get data by id from database successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(studentService.getStudentById(id))
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable("student-id") Integer id,@RequestBody StudentRequest studentRequest) {
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Update data by id to database successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(studentService.updateStudentById(id,studentRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudent(@PathVariable("student-id") Integer id) {
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Delete successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(studentService.deleteById(id))
                .build();
        return ResponseEntity.ok(response);
    }





}
