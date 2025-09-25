package com.mamabologtub.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamabologtub.library_system.entities.Student;

/**
 * @Author Tshepo M Mahudu on Jul 11, 2025.
 */

public interface StudentsRepository extends JpaRepository<Student, String> {

}
