package com.company;

import java.util.Comparator;

public class StudentComparatorByAverage implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return (int) (a.getAverageMark() - b.getAverageMark());
    }
}