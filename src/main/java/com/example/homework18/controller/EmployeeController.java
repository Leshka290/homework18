package com.example.homework18.controller;

import com.example.homework18.Employee;
import com.example.homework18.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/list")
    public List<Employee> returnListEmployee() {
        return employeeService.returnListEmployee();
    }
}
