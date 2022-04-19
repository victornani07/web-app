package com.endava.web.app.controller;

import com.endava.web.app.model.Employee;
import com.endava.web.app.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @PostMapping("/employees")
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.insertEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeServiceImpl.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId)  {
        return employeeServiceImpl.getEmployeeById(employeeId);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId,
                                       @RequestBody Employee employee) {

        return employeeServiceImpl.updateEmployeeById(employeeId, employee);
    }
}
