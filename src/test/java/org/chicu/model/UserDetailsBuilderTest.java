package org.chicu.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit Test
class UserDetailsBuilderTest {

    @Test
    void buildUserDetailsWhenBlank() {
        User subject = new User("system-abc-123");
        // act
        String actualDetails = UserDetailsBuilder.buildUserDetails(subject.getUsername());
        // expectations
        String expectedDetails = "Details: system-abc-123, magic processing";
        // checks
        assertEquals(expectedDetails, actualDetails, "Incorrect details were built");
    }
}