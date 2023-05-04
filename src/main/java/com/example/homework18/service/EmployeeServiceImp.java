package com.example.homework18.service;

import com.example.homework18.Employee;
import com.example.homework18.exception.EmployeeAlreadyAddedException;
import com.example.homework18.exception.EmployeeNotFoundException;
import com.example.homework18.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

            if (findIndexEmployee(firstName, lastName) != -1) {
                throw new EmployeeAlreadyAddedException();
            } else if (employees.size() >= maxAmountEmployee) {
                throw new EmployeeStorageIsFullException();
            } else {
                employees.add(employee);
                return employee;
            }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (findIndexEmployee(firstName, lastName) != -1) {
            employees.remove(findIndexEmployee(firstName, lastName));
            return new Employee(firstName, lastName);
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        if (findIndexEmployee(firstName, lastName) == -1) {
            throw new EmployeeNotFoundException();
        } else {
            return new Employee(firstName, lastName);
        }
    }

    public List<Employee> returnListEmployee() {
        return employees;
    }

    private int findIndexEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
