package com.endava.web.app.service;

import com.endava.web.app.model.Employee;
import com.endava.web.app.exceptions.EmployeeNotFoundException;
import com.endava.web.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if(!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id=" + employeeId + " was not found.");
        }

        return employeeOptional.get();
    }

    @Override
    public Employee updateEmployeeById(Long employeeId, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if(!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id=" + employeeId + " was not found.");
        }

        Employee emp = employeeOptional.get();

        if(employee.getFirstName() != null) {
            emp.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName() != null) {
            emp.setLastName(employee.getLastName());
        }
        if(employee.getEmail() != null) {
            emp.setEmail(employee.getEmail());
        }
        if(employee.getPhoneNumber() != null) {
            emp.setPhoneNumber(employee.getPhoneNumber());
        }
        if(employee.getSalary() != null) {
            emp.setSalary(employee.getSalary());
        }
        if(employee.getDepartment() != null) {
            emp.setDepartment(employee.getDepartment());
        }

        return employeeRepository.save(emp);
    }
}
