package org.homework.spring_homework02.repository;

import org.apache.ibatis.annotations.*;
import org.homework.spring_homework02.model.entity.Instructor;
import org.homework.spring_homework02.model.request.InstructorRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
            SELECT * FROM instructors
            OFFSET #{size} * (#{page} - 1)
            LIMIT #{size}
            """)
    @Results(id = "mapResultInstructor", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "instructorEmail", column = "email")
    })
    List<Instructor> getAllInstructors(@Param("page") Integer page, @Param("size") Integer size);

    @Select("SELECT * FROM instructors WHERE instructor_id = #{id}")
    @ResultMap("mapResultInstructor")
    Instructor getInstructorById(Integer id);

    @Select("""
            INSERT INTO instructors (instructor_name, email)
            VALUES (#{request.instructorName}, #{request.instructorEmail})
            RETURNING *
            """)
    @ResultMap("mapResultInstructor")
    Instructor insertInstructor(@Param("request") InstructorRequest instructorRequest);

    @Delete("""
            DELETE FROM instructors WHERE instructor_id = #{id}
            RETURNING *;
            """)
    @ResultMap("mapResultInstructor")
    Instructor deleteInstructorById(@Param("id") Integer id);

    @Select("""
            UPDATE instructors
            SET instructor_name = #{request.instructorName},
                  email = #{request.instructorEmail}
            WHERE instructor_id = #{id}
            RETURNING *;
    """)
   @ResultMap("mapResultInstructor")
    Instructor updateInstructorById(@Param("id") Integer id, @Param("request") InstructorRequest instructorRequest);
}
