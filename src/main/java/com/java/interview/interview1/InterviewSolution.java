package com.java.interview.interview1;

import com.java.interview.interview1.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewSolution {
    public static void main(String[] args) {

        // List of Employees
        List<Employee> employees = Arrays.asList(
                new Employee("Srikanth", 200000d),
                new Employee("Sindhuja", 100000d),
                new Employee("John", 45000d), // Added for testing purposes
                new Employee("Jane", 75000d) // Added for testing purposes
        );

        // 1. Get names of employees whose salary is greater than 50k
        Set<String> highEarners = employees
                .stream()
                .filter(employee -> employee.getSalary() > 50000)
                .map(Employee::getName)
                .collect(Collectors.toSet());

        System.out.println("Employees with salary greater than 50k: " + highEarners);

        // 2. Calculate the average salary of employees
        OptionalDouble averageSalary = employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average();

        if (averageSalary.isPresent()) {
            System.out.println("Average salary: " + averageSalary.getAsDouble());
        } else {
            System.out.println("No employees found.");
        }

        // 3. JavaScript ES6 Features - Example code (not executable in Java)
        /*
        // Spread operator
        const employee = { name: 'John', salary: 50000 };
        const newEmployee = { ...employee, position: 'Developer' };

        // Rest operator
        function validate(...args) {
            // args is an array of arguments
            console.log(args);
        }
        validate('arg1', 'arg2');

        // Array destructuring
        const [firstEmployee, secondEmployee] = [employee1, employee2];
        console.log(firstEmployee, secondEmployee);
        */
    }
}
