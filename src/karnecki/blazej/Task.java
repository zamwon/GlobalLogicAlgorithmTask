package karnecki.blazej;

import java.util.*;
import java.util.stream.Collectors;

public class Task {

    private static void logicOccurrences(String input) {

        Set<Character> charactersSetLOGIC = Set.of('L', 'O', 'G', 'I', 'C');

        String inputWithNoSpecialCharsWithSpaces = input.toUpperCase().replaceAll("[^a-zA-Z0-9]", " ");

        int inputLength = input.length();

        String inputWithNoSpecialCharsAndNoSpaces = input.replaceAll("[^a-zA-Z0-9]", "");
        int frazeLength = inputWithNoSpecialCharsAndNoSpaces.length();

        // Check list of split input
//      Arrays.stream(inputWithNoSpecialCharsWithSpaces.split(" ")).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        List<String> stringList = Arrays.stream(inputWithNoSpecialCharsWithSpaces.split(" ")).collect(Collectors.toList());

        Map<Map<Set<String>, Integer>, Integer> resultDict = new HashMap<>();

            for (String s : stringList) {
                Map<Set<String>, Integer> setIntegerMap = new HashMap<>();
                Set<String> charsInWord = new HashSet<>();
                int logicInKeyCounter = 0;
                for (Character c : charactersSetLOGIC) {
                    if (s.contains(String.valueOf(c))) {
                        charsInWord.add(String.valueOf(c));
                        logicInKeyCounter++;
                    }
                }
                setIntegerMap.put(charsInWord, s.length());
                System.out.println(charsInWord + ", " + setIntegerMap.get(charsInWord) + " logicC= " + logicInKeyCounter);
            }


    }

    public static void main(String[] args) {

        logicOccurrences("I love to work in global logic plate level!");
    }

}
