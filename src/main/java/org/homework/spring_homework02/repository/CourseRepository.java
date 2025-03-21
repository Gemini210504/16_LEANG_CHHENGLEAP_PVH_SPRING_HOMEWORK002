package org.homework.spring_homework02.repository;


import org.apache.ibatis.annotations.*;
import org.homework.spring_homework02.model.entity.Course;
import org.homework.spring_homework02.model.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
    SELECT * FROM courses
            OFFSET (#{page} - 1) * #{size}
            LIMIT #{size}
    """)
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.homework.spring_homework02.repository.InstructorRepository.getInstructorById"))
    })
    List<Course> getAllCoursesDetail(Integer page, Integer size);

    @Select("""
    SELECT * FROM courses WHERE course_id = #{id}
    """)
    @ResultMap("courseMapper")
    Course getCourseById(Integer id);

    @Select("""
            INSERT INTO courses (course_name, description, instructor_id)
            VALUES (#{request.courseName}, #{request.description}, #{request.instructorId})
            RETURNING *
            """)
    @ResultMap("courseMapper")
    Course insertCourse(@Param("request") CourseRequest  courseRequest);


    @Select("""
            UPDATE courses 
            SET course_name = #{request.courseName}, 
                description = #{request.description}, 
                instructor_id = #{request.instructorId}
            WHERE course_id = #{id}
            RETURNING *
    """)
    @ResultMap("courseMapper")
    Course updateCourseById(@Param("request") CourseRequest courseRequest ,Integer id);


    @Select("""
            DELETE FROM courses WHERE course_id = #{id}
            RETURNING *;
    """)
    @ResultMap("courseMapper")
    Course deleteById(Integer id);

}

