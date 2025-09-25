package com.mamabologtub.library_system.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mamabologtub.library_system.dtos.StudentDto;
import com.mamabologtub.library_system.entities.Student;
import com.mamabologtub.library_system.exception.CustomException;
import com.mamabologtub.library_system.repositories.StudentsRepository;
import com.mamabologtub.library_system.services.StudentsService;

/**
 * @Author Tshepo M Mahudu on Jul 11, 2025.
 */

@Service
public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentsRepository;

    @Override
    public Student registerStudent(StudentDto studentDto) {
        Student student = mapToDto(studentDto);
        Student registeredStudent = studentsRepository.save(student);
        return registeredStudent;
    }

    @Override
    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student getStudent(String id) {
        Optional<Student> studentOptional = studentsRepository.findById(id);
        if(studentOptional.isPresent()) {
            return studentOptional.get();
        }
        throw new CustomException("This student number does not exist", HttpStatus.NOT_FOUND.value());
    }

    @Override
    public Student deRegisterStudent(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    private Student mapToDto(StudentDto dto) {
        Student entity = new Student();
        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        entity.setRegistrationYear(dto.getRegistrationYear());
        return entity;
    }

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

}
