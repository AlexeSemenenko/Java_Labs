package com.company;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Student implements Serializable {
    String firstName;
    String lastName;
    int id;
    List<Session> sessions;
    private transient double averageMark;

    public double getAverageMark() {
        int sum = 0;
        int count = 0;
        for(Session session : this.sessions) {
            Pair<Integer, Integer> statics = session.getStatics();
            sum += statics.first;
            count += statics.second;
        }
        return (double)sum / count;
    }
}