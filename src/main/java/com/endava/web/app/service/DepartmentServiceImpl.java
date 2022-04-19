package com.endava.web.app.service;

import com.endava.web.app.model.Department;
import com.endava.web.app.exceptions.DepartmentNotFoundException;
import com.endava.web.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department insertDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if(!departmentOptional.isPresent()) {
            throw new DepartmentNotFoundException("Department with id=" + departmentId + " was not found.");
        }

        return departmentOptional.get();
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if(!departmentOptional.isPresent()) {
            throw new DepartmentNotFoundException("Department with id=" + departmentId + " was not found.");
        }

        Department dp = departmentOptional.get();

        if(dp.getDepartmentName() != null) {
            dp.setDepartmentName(department.getDepartmentName());
        }
        if(department.getLocation() != null) {
            dp.setLocation(department.getLocation());
        }

        return departmentRepository.save(dp);
    }
}
