package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        TokensCounter counter = new TokensCounter();

        try{
            FileReader fr = new FileReader("input.txt");
            Scanner sc = new Scanner(fr);

            while ((sc.hasNextLine())){
                counter.updateCounter(sc.nextLine());
            }

            fr.close();

            FileWriter fw = new FileWriter("output1.txt");
            fw.write(counter.getSortedWordsCount());
            fw.close();

            FileWriter fw1 = new FileWriter("output2.txt");
            fw1.write(String.join("", counter.getSeparatorsSet()));
            fw1.close();

            FileWriter fw2 = new FileWriter("output3.txt");
            fw2.write(String.join("", counter.getCharsSet()));
            fw2.close();

        } catch (IOException ex){
            System.out.println("File not found");
        }

    }
}
