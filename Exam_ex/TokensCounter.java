package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TokensCounter {
    private Map<String, Integer> wordsCounter;
    private Set<String> separatorsSet;
    private Set<String> charsSet;

    public TokensCounter(){
        wordsCounter = new LinkedHashMap<>();
        separatorsSet = new TreeSet<>();
        charsSet = new TreeSet<>(Comparator.reverseOrder());
    }

    public void updateCounter(String line){
        Matcher matcher = Pattern.compile("\\w+|.").matcher(line);

        while(matcher.find()){
            String token = matcher.group().toLowerCase();

            if(token.matches("\\w+")){
                if(wordsCounter.containsKey(token)){
                    wordsCounter.put(token, wordsCounter.get(token) + 1);
                }
                else{
                    wordsCounter.put(token, 1);
                }
            }
            else{
                separatorsSet.add(token);
            }

            for(char c : token.toCharArray()){
                charsSet.add(String.valueOf(c));
            }
        }
    }

    public String getSortedWordsCount(){
        StringBuilder sb = new StringBuilder();

        Stream<Map.Entry<String, Integer>> wordsStream = wordsCounter.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Iterator<Map.Entry<String, Integer>> wordsIterator = wordsStream.iterator();


        while(wordsIterator.hasNext()){
            Map.Entry<String, Integer> entry = wordsIterator.next();

            sb.append(entry.getKey()).append("(")
                    .append(entry.getValue()).append(")");
        }

        return sb.toString();
    }

    public Set<String> getSeparatorsSet(){
        return separatorsSet;
    }

    public Set<String> getCharsSet() {
        return charsSet;
    }
}
