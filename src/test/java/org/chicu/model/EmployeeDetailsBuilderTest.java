package org.chicu.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit Test
class EmployeeDetailsBuilderTest {

    @Test
    void buildUserDetailsWhenBlank() {
        Employee subject = new Employee("system-abc-123");
        // act
        String actualDetails = EmployeeDetailsBuilder.buildUserDetails(subject.getUsername());
        // expectations
        String expectedDetails = "Details: system-abc-123, magic processing";
        // checks
        assertEquals(expectedDetails, actualDetails, "Incorrect details were built");
    }
}