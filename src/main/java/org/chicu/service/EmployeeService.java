package org.chicu.service;

import lombok.RequiredArgsConstructor;
import org.chicu.model.Employee;
import org.chicu.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Collection<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public String createEmployee(Employee employee) {
        return employeeRepository.save(employee).getId().toString();
    }
}
