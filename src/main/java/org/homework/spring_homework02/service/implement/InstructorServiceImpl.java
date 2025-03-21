package org.homework.spring_homework02.service.implement;


import org.homework.spring_homework02.model.entity.Instructor;
import org.homework.spring_homework02.model.request.InstructorRequest;
import org.homework.spring_homework02.repository.InstructorRepository;
import org.homework.spring_homework02.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor updateInstructorById( Integer id,InstructorRequest instructorRequest) {
        return  instructorRepository.updateInstructorById(id,instructorRequest);
    }

    @Override
    public Instructor deleteInstructorById(Integer id) {
        return instructorRepository.deleteInstructorById(id);
    }

    @Override
    public List<Instructor> getAllInstructors(Integer page, Integer size) {
        return  instructorRepository.getAllInstructors(page, size);
    }

    @Override
    public Instructor addInstructor(InstructorRequest instructorRequest) {
        return  instructorRepository.insertInstructor(instructorRequest);
    }
}
