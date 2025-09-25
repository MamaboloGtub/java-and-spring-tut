package com.mamabologtub.library_system.services;

import java.util.List;

import com.mamabologtub.library_system.dtos.StudentDto;
import com.mamabologtub.library_system.entities.Student;

/**
 * @Author Tshepo M Mahudu on Jul 11, 2025.
 */

public interface StudentsService {

    Student registerStudent(StudentDto studentDto);
    List<Student> getStudents();
    Student getStudent(String id);
    Student deRegisterStudent(String id);
}
