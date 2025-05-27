package com.mamabologtub.employeemvc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamabologtub.employeemvc.models.Employee;

/**
 * @Author Tshepo M Mahudu on Apr 13, 2025.
 */

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {

}
