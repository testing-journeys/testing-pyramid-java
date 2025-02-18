package org.testing.journeys.service;

import lombok.RequiredArgsConstructor;
import org.testing.journeys.model.Employee;
import org.testing.journeys.repository.EmployeeRepository;
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
