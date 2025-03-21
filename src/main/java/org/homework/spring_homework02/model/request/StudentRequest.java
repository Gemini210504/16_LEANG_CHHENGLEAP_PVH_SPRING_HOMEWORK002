package org.homework.spring_homework02.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private Integer courseId;
}
