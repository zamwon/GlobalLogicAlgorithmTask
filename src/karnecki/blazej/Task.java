package karnecki.blazej;

import java.util.*;
import java.util.stream.Collectors;

public class Task {

    private void logicOccurrences(String input) {

        Set<Character> charactersSetLOGIC = new HashSet<>();

        int logicInWordCounter = 0;

        int inputLength = input.length();
        int specialChars = 0;
        int frazeLength = inputLength - specialChars;

        List<String> stringList = Arrays.stream(input.split(" ")).collect(Collectors.toList());





    }

    public static void main(String[] args) {

    }

}
