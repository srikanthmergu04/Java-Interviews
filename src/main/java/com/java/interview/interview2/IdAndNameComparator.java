package com.java.interview.interview2;

import com.java.interview.interview2.model.Employee;

import java.util.Comparator;

public class IdAndNameComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {

        int compare = Integer.compare(o1.getId(), o2.getId());

        if (compare == 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return compare;
        }

    }
}
