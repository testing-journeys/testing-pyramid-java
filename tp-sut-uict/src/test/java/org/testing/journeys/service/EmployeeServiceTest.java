package org.testing.journeys.service;

import org.testing.journeys.model.Employee;
import org.testing.journeys.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Unit Test (Service Components - Mocking dependencies)
@SpringBootTest(classes = EmployeeService.class)
class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @Test
    void getUsers() {
        // data
        List<Employee> expectedEmployees = Arrays.asList(
                new Employee("user-1", "user 1 details"),
                new Employee("user-1", "user 1 details"));
        // dependencies setup
        when(employeeRepository.findAll()).thenReturn(expectedEmployees);
        // act
        Collection<Employee> actualEmployees = employeeService.getEmployees();
        // assertions
        assertEquals(expectedEmployees, actualEmployees, "Users incorrectly retrieved");
    }
}