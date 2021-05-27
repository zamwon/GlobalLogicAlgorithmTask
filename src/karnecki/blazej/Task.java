package karnecki.blazej;

import java.util.*;
import java.util.stream.Collectors;

public class Task {

    private static void logicOccurrences(String input) {

        Set<Character> charactersSetLOGIC = Set.of('L', 'O', 'G', 'I', 'C');

        int logicInWordCounter = 0;
        String inputWithNoSpecialCharsWithSpaces = input.toUpperCase().replaceAll("[^a-zA-Z0-9]", " ");

        int inputLength = input.length();
//        System.out.println(input.length());

        String inputWithNoSpecialCharsAndNoSpaces = input.replaceAll("[^a-zA-Z0-9]", "");
        int frazeLength = inputWithNoSpecialCharsAndNoSpaces.length();
        System.out.println(frazeLength);

        // Check list of split input
//      Arrays.stream(inputWithNoSpecialCharsWithSpaces.split(" ")).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        List<String> stringList = Arrays.stream(inputWithNoSpecialCharsWithSpaces.split(" ")).collect(Collectors.toList());


        for (String s: stringList) {
            Map<Set<String>, Integer> setIntegerMap = new HashMap<>();
            Set<String> charsInWord = new HashSet<>();
            for (Character c : charactersSetLOGIC) {
                if(s.contains(c + "")){
                    charsInWord.add(String.valueOf(c));
                }
            }
            System.out.println(charsInWord);
//            System.out.println(setIntegerMap.put(charsInWord, s.length()));
        }

    }

    public static void main(String[] args) {

        logicOccurrences("I love to work in global logic!");
    }

}
