package com.company;

import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {
    public String name;
    public int id;
    public List<Session> sessions;

    @Override
    public int compareTo(Student otherStudent) {
        return this.name.compareTo(otherStudent.name) != 0 ?
                this.name.compareTo(otherStudent.name) : this.id - otherStudent.id;
    }

    public double averageMark(){
        int result = 0;
        int count = 0;
        for(Session session : sessions){
            for(Map.Entry<Subjects, Integer> subject : session.subjects.entrySet()){
                result += subject.getValue();
                count++;
            }
        }
        return (double)result / count;
    }
}