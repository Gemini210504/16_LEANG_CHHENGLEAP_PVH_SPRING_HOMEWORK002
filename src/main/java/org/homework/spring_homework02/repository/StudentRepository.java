package org.homework.spring_homework02.repository;


import org.apache.ibatis.annotations.*;
import org.homework.spring_homework02.model.entity.Student;
import org.homework.spring_homework02.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
            SELECT * FROM students 
            OFFSET (#{page} - 1) * #{size} 
            LIMIT #{size}
            """)
    @Results(id = "studentMapResults", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
    })
    List<Student> retrieveAllStudents(@Param("size") Integer size, @Param("page") Integer page);

    @Select("""
        INSERT INTO students ( student_name, email, phone_number) 
        VALUES (#{request.studentName}, #{request.email}, #{request.phoneNumber})
        RETURNING *
    """)
    @ResultMap("studentMapResults")
    Student createStudent(@Param("request") StudentRequest studentRequest);

    @Select ("""
            SELECT * FROM students WHERE student_id = #{id}
            """)
    @ResultMap("studentMapResults")
    Student selectStudentById(Integer id);


    @Select("""
            UPDATE students
            SET student_name = #{request.studentName},
                email = #{request.email},
                phone_number = #{request.phoneNumber}
            WHERE student_id = #{id}
            RETURNING *;
            """)
    @ResultMap("studentMapResults")
    Student updateStudentById(@Param("request") Integer id,StudentRequest studentRequest );

    @Select("""
            DELETE FROM students WHERE student_id = #{id}
            RETURNING *;
            """)
    Student deleteStudentById(Integer id);
}
