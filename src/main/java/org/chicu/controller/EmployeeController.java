package org.chicu.controller;

import org.chicu.model.Employee;
import org.chicu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

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
