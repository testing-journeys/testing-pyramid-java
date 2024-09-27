package org.chicu.repository;

import org.chicu.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql("/sql/employees.sql")
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findTopPerformerEmployee() {
        // data
        Employee expectedEmployees = new Employee(1L, "USER-1", "USER-1 DETAILS");
        // act
        Employee actualEmployees = employeeRepository.findTopPerformerEmployee();
        // assertions
        assertEquals(expectedEmployees, actualEmployees,
                "Actual employee does not match the expected one");
    }
}