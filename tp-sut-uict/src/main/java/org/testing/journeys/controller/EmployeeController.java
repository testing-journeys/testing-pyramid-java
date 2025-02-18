package org.testing.journeys.controller;

import lombok.RequiredArgsConstructor;
import org.testing.journeys.model.Employee;
import org.testing.journeys.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/api/v1/employees")
    @ResponseBody
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/api/v1/employees")
    @ResponseBody
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/ui/v1/employees")
    public String viewEmployees(Model model) {
        Collection<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }
}
