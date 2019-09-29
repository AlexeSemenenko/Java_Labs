package com.company;

import java.util.HashMap;
import java.util.Map;

public class Session {
    Map<Subjects, Integer> session = new HashMap<>();

    public Pair<Integer, Integer> getStatics() {
        int sum = 0;
        int count = 0;
        for(Subjects subject : session.keySet()) {
            sum += session.get(subject);
            count++;
        }
        return new Pair<Integer, Integer>(sum, count);
    }

    public double getSessionAverageMark() {
        Pair<Integer, Integer> statics = this.getStatics();
        return (double)statics.first / statics.second;
    }
}