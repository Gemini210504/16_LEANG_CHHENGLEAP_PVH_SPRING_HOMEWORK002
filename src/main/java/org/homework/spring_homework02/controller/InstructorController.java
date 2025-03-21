package org.homework.spring_homework02.controller;


import org.homework.spring_homework02.model.entity.Instructor;
import org.homework.spring_homework02.model.entity.Student;
import org.homework.spring_homework02.model.request.InstructorRequest;
import org.homework.spring_homework02.model.request.StudentRequest;
import org.homework.spring_homework02.model.response.ApiResponse;
import org.homework.spring_homework02.service.InstructorService;
import org.homework.spring_homework02.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getInstructors(Integer page, Integer size) {
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>> builder()
                .success(true)
                .message("Get data from database successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.getAllInstructors(page, size))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Add data to database successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.addInstructor(instructorRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping ("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Integer id) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Get data by id from database successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.getInstructorById(id))
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable("instructor-id") Integer id,@RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Update data by id to database successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.updateInstructorById(id,instructorRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable("instructor-id") Integer id) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Delete successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.deleteInstructorById(id))
                .build();
        return ResponseEntity.ok(response);
    }
}
