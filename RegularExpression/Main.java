package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        Scanner sc = new Scanner(fr);

        String str = sc.nextLine();
        fr.close();

        Pattern pattern = Pattern.compile("\\(.*?\\)");
        Matcher matcher = pattern.matcher(str);

        List<String> parts = new ArrayList<>();

        while(matcher.find()){
            parts.add(str.substring(matcher.start(), matcher.end()));
        }

        for(String temp : parts){
            str = str.replaceAll("\\(" + temp + "\\)", "");
        }

        FileWriter fw = new FileWriter("output.txt");

        fw.write(str);
        fw.close();
    }
}
