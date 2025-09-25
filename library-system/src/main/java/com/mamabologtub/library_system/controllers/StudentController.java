package com.mamabologtub.library_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamabologtub.library_system.dtos.StudentDto;
import com.mamabologtub.library_system.entities.Student;
import com.mamabologtub.library_system.services.StudentsService;

/**
 * @Author Tshepo M Mahudu on Jul 11, 2025.
 */

@RestController
@RequestMapping("/api/v2")
public class StudentController {

    @Autowired
    private StudentsService service;

    @PostMapping("/student")
    public ResponseEntity<Student> registerStudent(@RequestBody StudentDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerStudent(dto));
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return service.getStudents();
    }
    @GetMapping("/student/id")
    public Student getStudent(String id) {
        return service.getStudent(id);
    }

}
