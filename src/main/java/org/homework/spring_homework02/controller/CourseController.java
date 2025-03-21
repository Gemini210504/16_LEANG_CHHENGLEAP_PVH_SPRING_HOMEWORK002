package org.homework.spring_homework02.controller;

import org.homework.spring_homework02.model.entity.Course;
import org.homework.spring_homework02.model.request.CourseRequest;
import org.homework.spring_homework02.model.response.ApiResponse;
import org.homework.spring_homework02.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    ResponseEntity<ApiResponse<List<Course>>> getAllCourses(Integer page, Integer size) {
        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .message("Get data from database successfully")
                .status(HttpStatus.OK)
                .success(true)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.getAllCourses(page, size))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{course-id}")
    ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Integer id) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Get data by id from database successfully")
                .status(HttpStatus.OK)
                .success(true)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.getCourseById(id))
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Add data to database successfully")
                .status(HttpStatus.OK)
                .success(true)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.addCourse(courseRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{course-id}")
    ResponseEntity<ApiResponse<Course>> updateCourse(@RequestBody CourseRequest courseRequest, Integer id) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Update data in database successfully")
                .status(HttpStatus.OK)
                .success(true)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.updateCourseById(id, courseRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{course-id}")
    ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable("course-id") Integer id) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Delete data in database successfully")
                .status(HttpStatus.OK)
                .success(true)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.deleteById(id))
                .build();
        return ResponseEntity.ok(response);
    }

}
