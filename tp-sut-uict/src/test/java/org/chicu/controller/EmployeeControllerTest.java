package org.chicu.controller;

import org.chicu.model.Employee;
import org.chicu.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Unit Test (Controller Components - Mocking dependencies - MockMvc)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    @Test
    void getUsers() throws Exception {

        // dependencies setup
        when(employeeService.getEmployees())
                .thenReturn(Collections.singletonList(new Employee("user 1", "user 1 details")));

        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        """
                                [{"username":"user 1","details":"user 1 details"}]"""
                ));
    }
}