package karnecki.blazej;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

    private static void logicOccurrences(String input) {

        Set<Character> charactersSetLOGIC = Stream.of('L', 'O', 'G', 'I', 'C')
                .collect(Collectors.toCollection(LinkedHashSet::new));
//        charactersSetLOGIC.
//        Set.of('L', 'O', 'G', 'I', 'C');

        String inputWithNoSpecialCharsWithSpaces = input.toUpperCase().replaceAll("[^a-zA-Z0-9]", " ");

        int inputLength = input.length();

        String inputWithNoSpecialCharsAndNoSpaces = input.replaceAll("[^a-zA-Z0-9]", "");
        int frazeLength = inputWithNoSpecialCharsAndNoSpaces.length();

        // Check list of split input
//      Arrays.stream(inputWithNoSpecialCharsWithSpaces.split(" ")).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        List<String> stringList = Arrays.stream(inputWithNoSpecialCharsWithSpaces.split(" ")).collect(Collectors.toList());

        Map<Map<Set<String>, Integer>, Integer> resultDict = new HashMap<>();

        Map<Set<String>, Integer> setIntegerMap = new HashMap<>();
        int totalOccur = 0;
        for (String s : stringList) {
            Set<String> charsInWord = new LinkedHashSet<>();
            int count = 0;
            for (Character c : charactersSetLOGIC) {
                if (s.contains(String.valueOf(c))) {
                    charsInWord.add(String.valueOf(c));
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == c) {
                            count++;
                            totalOccur++;
                        }
                    }
                }
            }
            setIntegerMap.put(charsInWord, s.length());
            resultDict.put(setIntegerMap, count);


//            System.out.println(charsInWord + ", " + setIntegerMap.get(charsInWord) + " wystapienia= " + count + "/" + totalOccur);


        }

        int finalTotalOccur = totalOccur;
        setIntegerMap.forEach((k, v) -> System.out.println("{" + k + ", " + v + "} ile x " + resultDict.get(setIntegerMap) + " z " + finalTotalOccur));


    }

    public static void main(String[] args) {

        logicOccurrences("I love to work in global logic plate level!");
    }

}
