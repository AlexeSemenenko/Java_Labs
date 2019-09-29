package com.company;

import java.util.Comparator;

public class StudentComparatorByName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if(a.lastName.equals(b.lastName)) {
            return a.firstName.compareTo(b.firstName);
        }
        return a.lastName.compareTo(b.lastName);
    }
}