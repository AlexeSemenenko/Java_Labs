package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String fileIn = "input.txt";
        String fileOut1 = "output1.txt";
        String fileOut2 = "output2.txt";
        String fileOut3 = "output3.txt";

        try{
            FileReader fr = new FileReader(fileIn);
            Scanner sc = new Scanner(fr);

            List<String> listInits = new ArrayList<>();
            Map<String, String> mapForLiterals = new HashMap<>();

            FileWriter fw3 = new FileWriter(fileOut3);

            while(sc.hasNextLine()){
                Matcher matcher = Pattern.compile("(\\w+)\\s+\\w+\\s*=\\s*(\\S+)\\s*;").matcher(sc.nextLine());

                while (matcher.find()){
                    String init = matcher.group();
                    String value = matcher.group(2);

                    listInits.add(init);

                    if(value.charAt(0) == '\'' || value.charAt(0) == '\"'){
                        mapForLiterals.put(init, value.substring(1, value.length() - 1));
                    }
                    else{
                        mapForLiterals.put(init, value);
                    }

                    try{
                        switch (matcher.group(1)){
                            case "int":
                                Integer.parseInt(value);
                                break;
                            case "double":
                                Double.parseDouble(value);
                                break;
                            case "float":
                                Float.parseFloat(value);
                                break;
                            case "short":
                                Short.parseShort(value);
                                break;
                            case "long":
                                Long.parseLong(value);
                                break;
                            case "byte":
                                Byte.parseByte(value);
                                break;
                            case "boolean":
                                if(!value.equals("true") && !value.equals("false")){
                                    throw new NumberFormatException();
                                }
                                break;
                            case "char":
                                if(!value.matches("'.'")){
                                    throw new NumberFormatException();
                                }
                                break;
                            case "String":
                                if(!value.matches("\"[^\"]*\"")){
                                    throw new NumberFormatException();
                                }
                            default:
                                break;
                        }

                        fw3.write(init + " - yes\n");

                    }catch (NumberFormatException ex){
                        fw3.write(init + " - no\n");
                    }
                }
            }

            fw3.close();

            fr.close();

            listInits.sort(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int count1 = 0;
                    int count2 = 0;

                    for(Character c : s1.toCharArray()){
                        if(Character.isDigit(c)){
                            count1++;
                        }
                    }

                    for(Character c : s2.toCharArray()){
                        if(Character.isDigit(c)){
                            count2++;
                        }
                    }

                    return count2 - count1;
                }
            });

            FileWriter wr = new FileWriter(fileOut1);
            Iterator<String> listIterator = listInits.listIterator();

            while (listIterator.hasNext()){
                wr.write(listIterator.next() + "\n");
            }
            wr.close();

//            Iterator<Map.Entry<String, String >> mapIterator = mapForLiterals.entrySet().stream()
//                    .sorted(new Comparator<Map.Entry<String, String>>() {
//                        @Override
//                        public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) {
//                            return entry1.getValue().length() - entry2.getValue().length();
//                        }
//                    }).iterator();

            Iterator<Map.Entry<String, String >> mapIterator = mapForLiterals.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(new Comparator<String>() {
                        @Override
                        public int compare(String value1, String value2) {
                            return value1.length() - value2.length();
                        }
                    })).iterator();

            FileWriter fw1 = new FileWriter(fileOut2);

            while(mapIterator.hasNext()){
                fw1.write(mapIterator.next().getKey() + "\n");
            }

            fw1.close();

        } catch (IOException ex){
            System.out.println("File not found");
        }
    }
}
