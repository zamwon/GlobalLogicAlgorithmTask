package karnecki.blazej;

import java.util.*;
import java.util.stream.Collectors;

public class Task {

    private static void logicOccurrences(String input) {

        Set<Character> charactersSetLOGIC = new HashSet<>();

        int logicInWordCounter = 0;
        String inputWithNoSpecialCharsWithSpaces = input.replaceAll("[^a-zA-Z0-9]", " ");

        int inputLength = input.length();
        System.out.println(input.length());

        String inputWithNoSpecialCharsAndNoSpaces = input.replaceAll("[^a-zA-Z0-9]", "");

        int frazeLength = inputWithNoSpecialCharsAndNoSpaces.length();
        System.out.println(frazeLength);

        List<String> stringList = Arrays.stream(input.split(" ")).collect(Collectors.toList());





    }

    public static void main(String[] args) {

        logicOccurrences("I love to work in global logic!");
    }

}
