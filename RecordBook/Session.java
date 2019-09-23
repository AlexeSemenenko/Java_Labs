package com.company;

import java.util.Map;

public class Session {
    public Map<Subjects, Integer> subjects;
}

enum Subjects{
    CALCULUS,
    LINEAR_ALGEBRA,
    COMPUTER_SCIENCE,
    ENGLISH
}