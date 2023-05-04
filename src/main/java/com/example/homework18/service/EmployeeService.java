package com.example.homework18.service;

import com.example.homework18.Employee;

import java.util.List;

public interface EmployeeService {
    int maxAmountEmployee = 2;

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    List<Employee> returnListEmployee();
}
