package org.homework.spring_homework02.service.implement;


import org.homework.spring_homework02.model.entity.Course;
import org.homework.spring_homework02.model.request.CourseRequest;
import org.homework.spring_homework02.repository.CourseRepository;
import org.homework.spring_homework02.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course updateCourseById(Integer id, CourseRequest courseRequest) {
        return courseRepository.updateCourseById(courseRequest, id);
    }

    @Override
    public Course deleteById(Integer id) {
        return courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        return courseRepository.getAllCoursesDetail(page, size);
    }

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        return courseRepository.insertCourse(courseRequest);
    }
}
