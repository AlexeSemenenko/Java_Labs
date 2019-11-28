package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.WildcardType;
import java.util.Scanner;
import java.lang.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

        public static void initOperators(Set<String> operators) {
            operators.add("+");
            operators.add("*");
            operators.add("^");
        }

        public static int priority(final String operator) {
            return operator.equals("+") ? 1 :
                    operator.equals("*") ? 2 : -1;
                   //         operator.equals("/") ? 3 : -1;
        }

        public static void proceed(Stack<Double> operands, final String operator) {
            double right = operands.pop();
            double left = operands.pop();

            switch(operator) {
                case "+" : operands.add(Math.max(left, right)); break;
                case "*" : operands.add(Math.min(left, right)); break;
             //   case "/" : operands.add(left ^ right); break;
                }
            }

        public static double count(String statement) {
            Set<String> defaultOperators = new HashSet<>();

            initOperators(defaultOperators);

            Stack<String> operators = new Stack<>();
            Stack<Double> operands = new Stack<>();

            for (int i = 0; i < statement.length(); ++i) {

                String ch = String.valueOf(statement.charAt(i));

                if (Character.isDigit(statement.charAt(i)) || defaultOperators.contains(ch)) {
                    if (defaultOperators.contains(ch)) {
                        while (!operators.empty() && priority(operators.peek()) >= priority(ch)) {
                            proceed(operands, operators.pop());
                        }

                        operators.add(ch);
                    } else {
                        StringBuilder number = new StringBuilder();

                        while (i < statement.length() && Character.isDigit(statement.charAt(i))) {
                            number.append(statement.charAt(i++));
                        }
                        --i;

                        operands.add(Double.valueOf(number.toString()));
                    }
                }
            }

            while (!operators.empty()) {
                proceed(operands, operators.pop());
            }

            return operands.pop();
        }


    public  static  String toRightString(String str){
        String newStr = str.toLowerCase();
    //    newStr = newStr.replaceAll("not", "/");
        newStr = newStr.replaceAll("and", "*");
        newStr = newStr.replaceAll("or", "+");
        newStr = newStr.replaceAll(";", "");

        return newStr;
    }

    public static String value(String el){
        String newEl = el.toLowerCase();
        newEl = newEl.replaceAll("true", "1");
        newEl = newEl.replaceAll("false", "0");
        newEl = newEl.replaceAll("\\s*=\\s*", " ");


        return newEl;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str;


        System.out.println("Enter number of expressions: ");
        int count;
        count = sc.nextInt();

        FileReader fr = new FileReader("input1.txt");
        Scanner scn = new Scanner(fr);

        String[] expressoins = new String[count];
        for(int i = 0; i < count; i++){
            str = scn.nextLine();
            expressoins[i] = toRightString(str);
        }
        fr.close();


        System.out.println("Enter number of elements: ");
        int elCount;
        elCount = sc.nextInt();

        FileReader fr1 = new FileReader("input2.txt");
        Scanner scn1 = new Scanner(fr1);

        String[] elements = new String[elCount];
        for(int i = 0; i < elCount; i++){
            str = scn1.nextLine();
            elements[i] = value(str);
        }
        fr1.close();


        for(int i = 0; i < count; i++){
            for(int j = 0; j < elCount; j++){
                expressoins[i] = expressoins[i].replace(elements[j].charAt(0), elements[j].charAt(2));
            }
        }

        FileWriter wr = new FileWriter("output.txt");
        for (int i = 0; i < count; i++) {
            wr.write(expressoins[i] + " = " + count(expressoins[i]) + "\n");
        }
        wr.close();
    }
}
