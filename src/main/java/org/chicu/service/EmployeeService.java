package org.chicu.service;

import org.chicu.model.Employee;
import org.chicu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Collection<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public String createEmployee(Employee employee) {
        return employeeRepository.save(employee).getId().toString();
    }
}
