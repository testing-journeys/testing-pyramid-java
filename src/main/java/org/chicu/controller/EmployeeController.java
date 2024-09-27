package org.chicu.controller;

import org.chicu.model.Employee;
import org.chicu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/v1/employees")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}
