package com.mamabologtub.employeemvc.services;

import java.util.List;
import java.util.UUID;

import com.mamabologtub.employeemvc.models.Employee;

/**
 * @Author Tshepo M Mahudu on Apr 13, 2025.
 */

public interface EmployeeService {
    Employee getEmployee(UUID id);

    List<Employee> listEmployees();

}
