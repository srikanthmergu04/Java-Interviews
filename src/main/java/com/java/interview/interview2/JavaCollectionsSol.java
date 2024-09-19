package com.java.interview.interview2;

import com.java.interview.interview2.model.Employee;

import java.util.List;

public class JavaCollectionsSol {

    public static void main(String[] args) {

        List<Employee> employeeList = List.of(new Employee(20, "Arjun")
                , new Employee(10, "Tharun")
                , new Employee(8, "Srikanth")
                , new Employee(35, "Raju"));


        employeeList
                .stream()
                .sorted(new IdAndNameComparator())
                .forEach(employee -> System.out.println(employee));

    }
}
