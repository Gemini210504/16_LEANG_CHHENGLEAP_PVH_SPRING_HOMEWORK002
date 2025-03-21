package org.homework.spring_homework02.service;
import org.homework.spring_homework02.model.entity.Instructor;
import org.homework.spring_homework02.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    Instructor getInstructorById(Integer id);
    Instructor updateInstructorById( Integer id,InstructorRequest instructorRequest);
    Instructor deleteInstructorById(Integer id);
    List<Instructor> getAllInstructors(Integer page, Integer size);
    Instructor addInstructor(InstructorRequest instructorRequest);
}
