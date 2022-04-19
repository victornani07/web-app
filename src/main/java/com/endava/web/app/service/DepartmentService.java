package com.endava.web.app.service;

import com.endava.web.app.model.Department;

import java.util.List;

public interface DepartmentService {
    Department insertDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);
}
