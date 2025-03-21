package org.homework.spring_homework02.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer courseId;
    private String courseName;
    private String description;
    @JsonIgnore
    private Integer instructorId;
    private Instructor instructor;
}
