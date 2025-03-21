package org.homework.spring_homework02.service;

import org.homework.spring_homework02.model.entity.Course;
import org.homework.spring_homework02.model.request.CourseRequest;

import java.util.List;

public interface CourseService {

    Course getCourseById(Integer id);
    Course updateCourseById(Integer id, CourseRequest courseRequest);
    Course deleteById(Integer id);
    List<Course> getAllCourses(Integer page, Integer size);
    Course addCourse(CourseRequest courseRequest);

}
