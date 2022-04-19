package com.endava.web.app.service;

import com.endava.web.app.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee insertEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(Long employeeId);

    Employee updateEmployeeById(Long employeeId, Employee employee);
}
